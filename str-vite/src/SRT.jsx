import React, { useState, useEffect } from "react";
import Chart from "chart.js/auto";
import Card from "./Card";
import "./index.css";

function SRTSimulator() {
  const [processes, setProcesses] = useState([]); // Almacena la lista de procesos
  const [currentProcess, setCurrentProcess] = useState(null); // Almacena el proceso actual en ejecución
  const [numberOfProcess, setNumberOfProcess] = useState(0); // Almacena la cantidad de procesos a agregar
  const [completedProcesses, setCompletedProcesses] = useState([]);

  // Función para agregar procesos aleatorios a la lista
  const addProcess = () => {
    let tempProcess = [];
    for (let i = 0; i < numberOfProcess; i++) {
      const time = Math.floor(Math.random() * (10 - 1 + 1)) + 1;
      const newProcess = {
        name: "Proceso " + i,
        burstTime: time, // Tiempo de ráfaga aleatorio
        remainingTime: time, // Tiempo restante aleatorio
      };
      tempProcess.push(newProcess);
    }
    setProcesses(tempProcess);
    updateChart(tempProcess); // Actualiza el gráfico cuando se agregan nuevos procesos
  };

  // Función para ejecutar el planificador de SRT
  const runScheduler = () => {
    if (processes.length === 0) {
      return;
    }

    // Encuentra el proceso con el tiempo restante más corto
    const shortestProcess = processes.reduce((shortest, process) =>
      process.remainingTime < shortest.remainingTime ? process : shortest
    );

    setCurrentProcess(shortestProcess); // Establece el proceso actual en ejecución

    // Actualiza el tiempo restante de todos los procesos
    const updatedProcesses = processes.map((process) => {
      if (process === shortestProcess) {
        return {
          ...process,
          remainingTime: process.remainingTime - 1,
        };
      }
      return process;
    });

    setProcesses(updatedProcesses);

    if (shortestProcess.remainingTime === 0) {
      setCompletedProcesses((prev) => [...prev, shortestProcess]);
      // Encuentra el próximo proceso con el tiempo restante más corto
      const remainingProcesses = processes.filter(
        (process) => process !== shortestProcess
      );
      if (remainingProcesses.length > 0) {
        const nextShortestProcess = remainingProcesses.reduce(
          (shortest, process) =>
            process.remainingTime < shortest.remainingTime ? process : shortest
        );
        setCurrentProcess(nextShortestProcess); // Establece el próximo proceso en ejecución
      } else {
        setCurrentProcess(null); // No hay más procesos para ejecutar
      }

      setProcesses(remainingProcesses);
    }
    updateChart(); // Actualiza el gráfico después de cada ejecución del planificador
  };

  // Configuración de un temporizador con useEffect para ejecutar el planificador
  useEffect(() => {
    if (processes.length > 0 && currentProcess) {
      const timer = setTimeout(runScheduler, 1000); // Simula un quantum de tiempo (1 segundo)
      return () => clearTimeout(timer);
    }
  }, [processes, currentProcess]);

  useEffect(() => {
    updateChart();
  }, []);

  const updateChart = (data) => {
    const canvas = document.getElementById("processChart");
    const ctx = canvas.getContext("2d");

    // Extract the names and remaining times of the processes
    let processNames = processes.map((process) => process.name);
    let remainingTimes = processes.map((process) => process.remainingTime);

    if (data) {
      processNames = data.map((process) => process.name);
      remainingTimes = data.map((process) => process.remainingTime);
    }

    if (canvas.chart) {
      // Si existe una instancia previa del gráfico, actualiza solo los datos
      canvas.chart.data.labels = processNames;
      canvas.chart.data.datasets[0].data = remainingTimes;

      if (currentProcess) {
        // Resalta el proceso actual en un color diferente
        const currentProcessIndex = processNames.indexOf(currentProcess.name);
        canvas.chart.data.datasets[0].backgroundColor = remainingTimes.map(
          (time, index) =>
            index === currentProcessIndex
              ? "rgb(247, 161, 211)"
              : "rgb(109, 77, 157)"
        );
      }

      canvas.chart.update();
    } else {
      console.log("entro else");
      // Si no hay una instancia previa del gráfico, crea una nueva instancia
      const chart = new Chart(ctx, {
        type: "bar",
        data: {
          labels: processNames,
          datasets: [
            {
              label: "Timpo Restante",
              data: remainingTimes,
              backgroundColor: "rgb(109, 77, 157)",
              borderColor: "rgb(0, 0, 0, 0.6)",
              borderWidth: 1,
            },
          ],
        },
        options: {
          scales: {
            y: {
              beginAtZero: true,
            },
          },
        },
      });

      // Almacena la instancia del gráfico en el elemento de lienzo
      canvas.chart = chart;
    }
  };

  // Renderizado de elementos en la interfaz
  return (
    <div className="container">
      <h1 className="title">Simulador del Planificador SRT</h1>
      <div className="form">
        <label>Numero de procesos </label>
        <input
          className="input"
          type="number"
          placeholder="0"
          onChange={(e) => setNumberOfProcess(e.target.value)}
        />
        <button onClick={() => addProcess()} className="btn">
          Agregar
        </button>
        <button onClick={runScheduler} className="btn -s">
          Simular
        </button>
      </div>
      <div className="procesos">
        <div className="list">
          <h2 className="subTitle">Procesos</h2>
          {processes.length > 0 ? processes.map((process) => (
            <div className="item">
              {process.name} {" → "} {process.remainingTime} s
            </div>
          )) : <p>No hay procesos</p>}
        </div>
        <div className="grafica">
          <h2 className="subTitle">Tiempos de ejecución del CPU</h2>
          {currentProcess && (
            <b>
              {currentProcess.name} {" → "} {currentProcess.remainingTime}
              {" s"}
            </b>
          )}
          <canvas id="processChart"></canvas>
        </div>
      </div>

      <div className="listF">
        <h2 className="subTitle">Processes Terminados</h2>
        {completedProcesses.length > 0 ? completedProcesses.map((process) => (
          <div className="itemF" key={process.name}>
            {process.name}: {process.burstTime} s
          </div>
        )) : <p>No hay procesos Terminados</p>}
      </div>
    </div>
  );
}

export default SRTSimulator;
