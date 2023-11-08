import React, { useState, useEffect } from "react";

const Mlq = () => {
  const [highPriorityQueue, setHighPriorityQueue] = useState([]);
  const [mediumPriorityQueue, setMediumPriorityQueue] = useState([]);
  const [lowPriorityQueue, setLowPriorityQueue] = useState([]);
  const priorities = ["low", "medium", "high"];

  const [lengthLow, setLengtLow] = useState(0);
  const [lengthMedium, setLengthMedium] = useState(0);
  const [lengthHigh, setLengthHigh] = useState(0);

  const [numberOfProcess, setNumberOfProcess] = useState(0); // Almacena la cantidad de procesos a agregar

  const [isOver, setIsOver] = useState(false);
  const [isIn, setIsIn] = useState(false);

  // Función para agregar procesos aleatorios a las distintas colas
  const addProcess = () => {
    setIsIn(true);
    let tempProcessLow = [];
    let tempProcessMedium = [];
    let tempProcessHigh = [];
    for (let i = 0; i < numberOfProcess; i++) {
      const time = Math.floor(Math.random() * (10 - 1 + 1)) + 1;
      const priority =
        priorities[Math.floor(Math.random() * priorities.length)];
      const newProcess = {
        name: "Proceso " + i,
        priority: priority, // Tiempo de ráfaga aleatorio
        time: time, // Tiempo restante aleatorio
      };

      if (priority === "low") {
        tempProcessLow.push(newProcess);
      } else if (priority === "medium") {
        tempProcessMedium.push(newProcess);
      } else if (priority === "high") {
        tempProcessHigh.push(newProcess);
      }
    }
    setHighPriorityQueue(tempProcessHigh);
    setMediumPriorityQueue(tempProcessMedium);
    setLowPriorityQueue(tempProcessLow);
    setLengthHigh(tempProcessHigh.length);
    setLengthMedium(tempProcessMedium.length);
    setLengtLow(tempProcessLow.length);

    // updateChart(tempProcess); // Actualiza el gráfico cuando se agregan nuevos procesos
  };

  // Configuración de un temporizador con useEffect para ejecutar el planificador
  useEffect(() => {
    const timers = [];

    if (highPriorityQueue.length > 0) {
      timers.push(
        new Promise((resolve) => {
          const timer = setTimeout(() => {
            setHighPriorityQueue((prev) => prev.slice(1));
            clearTimeout(timer);
            resolve();
          }, 1000);
        })
      );
    }

    if (mediumPriorityQueue.length > 0) {
      timers.push(
        new Promise((resolve) => {
          const timer = setTimeout(() => {
            setMediumPriorityQueue((prev) => prev.slice(1));
            clearTimeout(timer);
            resolve();
          }, 1500);
        })
      );
    }

    if (lowPriorityQueue.length > 0) {
      timers.push(
        new Promise((resolve) => {
          const timer = setTimeout(() => {
            setLowPriorityQueue((prev) => prev.slice(1));
            clearTimeout(timer);
            resolve();
          }, 2000);
        })
      );
    }

    // Ejecutar todas las promesas en paralelo
    Promise.all(timers).then(() => {
      // Todas las actualizaciones de cola se han completado
      if (
        highPriorityQueue.length === 0 &&
        mediumPriorityQueue.length === 0 &&
        lowPriorityQueue.length === 0 &&
        isIn
      ) {
        setIsOver(true);
      }
    });
  }, [highPriorityQueue, mediumPriorityQueue, lowPriorityQueue]);

  return (
    <div className="mlq-page">
      <div className="card">
        <h1>Simulador de Prosesos MLQ</h1>
        <div className="card-progress --form">
          <label htmlFor="inp-number" className="lbl">
            Numero de procesos
          </label>
          <input
            type="number"
            id="inp-number"
            className="input-number"
            onChange={(e) => setNumberOfProcess(e.target.value)}
          />
          <button onClick={addProcess} className="btn">Simular</button>
        </div>
        <div className="card-progress">
          <label htmlFor="high-progress" className="lbl">
            Progreso de alta prioridad:
          </label>
          <progress
            id="high-progress"
            className="progress-bar high"
            value={lengthHigh - highPriorityQueue.length}
            max={lengthHigh}
          />
        </div>
        <div className="card-progress">
          <label htmlFor="medium-progress" className="lbl">
            Progreso de media prioridad:
          </label>
          <progress
            id="medium-progress"
            className="progress-bar medium"
            value={lengthMedium - mediumPriorityQueue.length}
            max={lengthMedium}
          />
        </div>
        <div className="card-progress">
          <label htmlFor="low-progress" className="lbl">
            Progreso de baja prioridad:
          </label>
          <progress
            id="low-progress"
            className="progress-bar low"
            value={lengthLow - lowPriorityQueue.length}
            max={lengthLow}
          />
        </div>
        {isOver && (
          <div className="over">
            <h2 className="over-msg">Todas las tareas se han ejecutado</h2>
          </div>
        )}
      </div>
    </div>
  );
};

export default Mlq;
