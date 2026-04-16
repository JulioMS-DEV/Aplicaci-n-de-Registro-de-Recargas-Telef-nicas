Mis Recargas - App de Registro
Una aplicación Android moderna desarrollada con Jetpack Compose y Material Design 3 para gestionar el registro de recargas telefónicas de manera eficiente y visualmente atractiva.
🚀 Características
La aplicación está dividida en tres áreas de responsabilidad clave:
1.
Estructura Principal: Diseño basado en Scaffold y Surface con un sistema de tipografía jerárquico.
2.
Gestión de Datos: Campos de entrada validados para número de teléfono y monto, junto con un selector dinámico de compañía telefónica.
3.
Confirmación Visual: Presentación de resultados mediante una ElevatedCard con animaciones de entrada y estados dinámicos.
🛠️ Tecnologías y Conceptos Utilizados
•
Jetpack Compose: Construcción de UI declarativa.
•
Material Design 3 (M3): Uso de componentes avanzados como ExposedDropdownMenuBox, ElevatedCard y tokens de color (primaryContainer, onSurfaceVariant).
•
Manejo de Estado: Uso de remember y mutableStateOf para controlar la reactividad de la interfaz.
•
Animaciones: Implementación de AnimatedVisibility para una experiencia de usuario fluida.
•
Accesibilidad: Iconografía con descripciones de contenido y contrastes optimizados según el MaterialTheme.
📱 Interacción del Usuario
1.
Ingreso de Datos: El usuario introduce el número y el monto. Si intenta registrar sin completar los campos, la interfaz muestra mensajes de error dinámicos (supportingText).
2.
Selección de Operador: Un menú desplegable interactivo permite elegir entre las compañías disponibles.
3.
Registro: Al presionar el botón, se procesan los datos y aparece una tarjeta de confirmación con el resumen de la transacción.
4.
Nueva Operación: Opción de limpiar el formulario para realizar un nuevo registro rápidamente.
📐 Decisiones de Diseño (Para Presentación)
•
Jerarquía Visual: Se utilizó FontWeight.ExtraBold en títulos y labelLarge en etiquetas para guiar la lectura.
•
Feedback Inmediato: El uso de isError en los campos de texto proporciona una respuesta visual instantánea ante errores de validación.
•
Consistencia: Se aplicó un Surface base vinculado al MaterialTheme.colorScheme.background para asegurar que la app respete el modo claro/oscuro del sistema.
🛠️ Requisitos
•
Android Studio Koala o superior.
•
JDK 17+.
•
Dispositivo o Emulador con API 24 (Android 7.0) o superior.
Cómo ejecutar el proyecto
1.
Clona este repositorio.
2.
Abre el proyecto en Android Studio.
3.
Sincroniza Gradle y ejecuta la aplicación en tu dispositivo.
