# Lista de listas (matriz de 5x3)
alumnos = [
    ["Ana", "101", "9.5"],
    ["Carlos", "102", "8.0"],
    ["Elena", "101", "10.0"],
    ["David", "103", "7.5"],
    ["Sofia", "102", "9.1"]
]

print("--- SISTEMA ESCOLAR (Python) ---")
for alumno in alumnos:
    print(f"Alumno: {alumno[0]} | Salon: {alumno[1]} | Promedio: {alumno[2]}")