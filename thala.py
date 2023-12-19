import subprocess
import tkinter as tk
from tkinter import messagebox

def display_gif_image(gif_path):
    subprocess.run(["start", "explorer", gif_path], shell=True)

def play_success_sound():
    song_path = r"C:\Users\chira\Downloads\Thala\Thala.m4a"
    subprocess.run(["start", "wmplayer", song_path], shell=True)

def check_string_length():
    entered_string = string_entry.get()

    if len(entered_string) == 7:
        gif_path = r"C:\Users\chira\Downloads\Thala\bole jo koyal.gif"
        display_gif_image(gif_path)
        play_success_sound()
        messagebox.showinfo("Congratulations", "Thala for a reason ❤")
    else:
        messagebox.showinfo("Try Again", "The length of the string is not 7. Try again!")

def perform_calculation():
    num1 = entry_num1.get()
    num2 = entry_num2.get()
    operation = operation_var.get()

    try:
        num1 = float(num1)
        num2 = float(num2)

        if operation == "Addition":
            result = num1 + num2
        elif operation == "Subtraction":
            result = num1 - num2
        else:
            result = "Invalid operation"

        if result == 7:
            gif_path = r"C:\Users\chira\Downloads\Thala\bole jo koyal.gif"
            display_gif_image(gif_path)
            play_success_sound()
            messagebox.showinfo("Thala", "Thala for a reason ❤")
        else:
            messagebox.showinfo("Result", f"The result is: {result}")

    except ValueError:
        messagebox.showerror("Error", "Please enter valid numbers.")

# GUI setup
root = tk.Tk()
root.title("Thala String Counter and Calculator")

# String Counter Section
string_label = tk.Label(root, text="Enter a string:")
string_label.pack()

string_entry = tk.Entry(root, width=30)
string_entry.pack()

check_button = tk.Button(root, text="Check Length", command=check_string_length)
check_button.pack()

# Calculator Section
calculator_label = tk.Label(root, text="\nCalculator\n")
calculator_label.pack()

entry_num1 = tk.Entry(root, width=10, justify="center")
entry_num1.pack(side=tk.LEFT)

operation_var = tk.StringVar()
operation_var.set("Addition")  # Default operation

operation_menu = tk.OptionMenu(root, operation_var, "Addition", "Subtraction")
operation_menu.pack(side=tk.LEFT)

entry_num2 = tk.Entry(root, width=10, justify="center")
entry_num2.pack(side=tk.LEFT)

calc_button = tk.Button(root, text="Calculate", command=perform_calculation)
calc_button.pack()

# Simulating user input
root.mainloop()
