import tkinter as tk;
from tkinter import END, messagebox;

root = tk.Tk();
root.title ("Practica 1");
root.config(width=300, height=300);

def Mensage ():
    nombre = txtNombre.get();
    messagebox.showinfo(message="Hola: " + nombre);

tk.Label(root, text="Ingrese su nombre").place(x=10, y=20);
txtNombre = tk.Entry(root);
txtNombre.place(x=10, y=50);
btnVer = tk.Button(root, text="Ver mensage", command=lambda: Mensage())
btnVer.place(x=10, y=80);

root.mainloop();