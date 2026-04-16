# 📱 Mis Recargas - Registro Inteligente

**Mis Recargas** es una solución móvil nativa para Android diseñada bajo el paradigma de **Programación Declarativa**. La aplicación optimiza la gestión y el registro de transacciones telefónicas, priorizando una experiencia de usuario (UX) fluida y una arquitectura limpia utilizando **Jetpack Compose** y **Material Design 3**.

## 🚀 Características Principales

La arquitectura de la aplicación se divide en tres pilares de responsabilidad:

1.  **Arquitectura de UI:** Estructura fundamentada en contenedores `Scaffold` y `Surface`, garantizando una jerarquía visual coherente y soporte nativo para **Dark Mode**.
2.  **Lógica de Negocio y Validación:** Sistema dinámico de entrada de datos con validación en tiempo real para números telefónicos y montos, integrando un selector de operadores reactivo.
3.  **Feedback Visual de Transacción:** Presentación de resultados mediante `ElevatedCard` enriquecida con micro-interacciones y animaciones de estado.

## 🛠️ Stack Tecnológico

* **Core:** [Jetpack Compose](https://developer.android.com/jetpack/compose) (UI Declarativa).
* **Diseño:** [Material Design 3](https://m3.material.io/) (Componentes avanzados: `ExposedDropdownMenuBox`, `ElevatedCard`).
* **Estado:** Gestión de estado reactivo mediante `remember` y `mutableStateOf`.
* **Animaciones:** Transiciones fluidas con `AnimatedVisibility`.
* **Accesibilidad:** Implementación de Content Descriptions y contrastes optimizados según estándares WCAG.

## 📐 Decisiones de Ingeniería y Diseño

* **UX Determinística:** Implementación de `isError` y `supportingText` en campos de texto para proporcionar feedback inmediato, reduciendo la tasa de error del usuario.
* **Jerarquía de Tipografía:** Uso estratégico de tokens de `MaterialTheme.typography` (`ExtraBold` para encabezados y `labelLarge` para formularios) para optimizar la escaneabilidad.
* **Escalabilidad:** El diseño basado en componentes permite la fácil integración futura de nuevas pasarelas de pago o proveedores de servicios.

## 📱 Flujo del Usuario

1.  **Captura de Datos:** Formulario inteligente con validaciones de tipo de dato.
2.  **Selección de Operador:** Interfaz de selección mediante menú desplegable dinámico.
3.  **Procesamiento:** Registro con confirmación visual instantánea mediante tarjetas de resumen.
4.  **Reset de Estado:** Función de limpieza de buffer para operaciones consecutivas rápidas.

## ⚙️ Requisitos del Entorno

* **IDE:** Android Studio Koala o superior.
* **JDK:** 17 o superior.
* **SDK:** API 24+ (Android 7.0+).

## 🚀 Instalación y Ejecución

1.  **Clonar:** `git clone [URL-del-repositorio]`
2.  **Importar:** Abrir la carpeta raíz en Android Studio.
3.  **Build:** Sincronizar Gradle y ejecutar en emulador o dispositivo físico.
