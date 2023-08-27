import tkinter as tk

def realizar_calculo():
    try:
        num1 = float(entry_num1.get())
        num2 = float(entry_num2.get())
        operacion = operacion_var.get()

        if operacion == "+":
            resultado.set(num1 + num2)
        elif operacion == "-":
            resultado.set(num1 - num2)
        elif operacion == "*":
            resultado.set(num1 * num2)
        elif operacion == "/":
            resultado.set(num1 / num2)
        else:
            resultado.set("Operación no válida")
    except ValueError:
        resultado.set("Entrada inválida")

# Configuración de la ventana
ventana = tk.Tk()
ventana.title("Calculadora Básica")
ventana.geometry("300x300")

# Variables de entrada y operación
entry_num1 = tk.Entry(ventana)
entry_num2 = tk.Entry(ventana)
operacion_var = tk.StringVar()
operacion_var.set("+")

# Resultado
resultado = tk.StringVar()
resultado.set("Resultado")

# Etiquetas y botones
label_num1 = tk.Label(ventana, text="Número 1:")
label_num2 = tk.Label(ventana, text="Número 2:")
label_operacion = tk.Label(ventana, text="Operación:")
label_resultado = tk.Label(ventana, textvariable=resultado)
boton_calcular = tk.Button(ventana, text="Calcular", command=realizar_calculo)

# Radiobuttons para las opciones de operación
radiobtn_suma = tk.Radiobutton(ventana, text="+", variable=operacion_var, value="+")
radiobtn_resta = tk.Radiobutton(ventana, text="-", variable=operacion_var, value="-")
radiobtn_mult = tk.Radiobutton(ventana, text="*", variable=operacion_var, value="*")
radiobtn_div = tk.Radiobutton(ventana, text="/", variable=operacion_var, value="/")

# Posicionamiento de widgets 
label_num1.place(x=10, y=10)
entry_num1.place(x=100, y=10)
label_num2.place(x=10, y=40)
entry_num2.place(x=100, y=40)
label_operacion.place(x=10, y=70)
radiobtn_suma.place(x=100, y=70)
radiobtn_resta.place(x=150, y=70)
radiobtn_mult.place(x=200, y=70)
radiobtn_div.place(x=250, y=70)
boton_calcular.place(x=10, y=100)
label_resultado.place(x=10, y=130)

# Iniciar la aplicación
ventana.mainloop()
