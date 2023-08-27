import tkinter as tk;
from tkinter import END, messagebox;
import calendar

root = tk.Tk();
root.title ("Mes");
root.config(width=300, height=300);

def Mensage ():
    numero = txtNumero.get();
    if (int(numero) > 0 and int(numero) < 13):
        nombre_mes = calendar.month_name[int(numero)]
        messagebox.showinfo(message= numero + " -> " + nombre_mes);
    else : 
        messagebox.showerror(message="Invalid");


tk.Label(root, text="Ingrese el numero del mes").place(x=10, y=20);
txtNumero = tk.Entry(root);
txtNumero.place(x=10, y=50);
btnVer = tk.Button(root, text="Ver mensage", command=lambda: Mensage())
btnVer.place(x=10, y=80);

root.mainloop();