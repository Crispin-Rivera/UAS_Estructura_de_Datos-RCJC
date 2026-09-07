alumnos = []

print("--- INGRESO DE DATOS (Python) ---")
for i in range(5):
    print(f"Alumno {i + 1}:")
    nombre = input("  Nombre: ")
    salon = input("  Salon: ")
    promedio = input("  Promedio: ")
    alumnos.append([nombre, salon, promedio])

print("\n--- DATOS REGISTRADOS ---")
for alumno in alumnos:
    print(f"Alumno: {alumno[0]} | Salon: {alumno[1]} | Promedio: {alumno[2]}")