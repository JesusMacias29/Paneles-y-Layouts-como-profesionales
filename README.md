🖥️ GestorUsuarios
📋 Descripción

GestorUsuarios es una aplicación de escritorio en Java Swing que simula la gestión de usuarios. La ventana principal combina distintos layouts para organizar los componentes de manera clara y adaptable.

Características principales:

🟢 Header (NORTH): título de la ventana con icono.

📌 Panel de navegación lateral (WEST): 5 botones (Dashboard, Usuarios, Informes, Ajustes, Ayuda).

📝 Formulario central (CENTER): campos Nombre, Email, Rol (ComboBox), Activo (CheckBox) y Notas (TextArea) usando GridBagLayout.

📊 Panel de previsualización (EAST): JTabbedPane con pestañas “Resumen” y “Logs”.

🔘 Botonera (SOUTH): botones Cancelar, Limpiar y Guardar.

✅ Diálogo modal: confirmación al pulsar Guardar.



🎯 Objetivos

Practicar distintos layouts de Swing: BorderLayout, FlowLayout, GridLayout y GridBagLayout.

Aprender a organizar una interfaz profesional combinando varios paneles.

Aplicar propiedades clave de GridBagLayout: weightx, weighty, fill, anchor e insets.

Implementar un diálogo modal de confirmación.

Verificar el comportamiento de los componentes al redimensionar la ventana.



⚙️ Instalación y ejecución

Clonar el repositorio:

git clone https://github.com/tu-usuario/GestorUsuarios.git


Abre el proyecto en IntelliJ IDEA o tu IDE favorito.

Ejecuta la clase principal:

java GestorUsuarios


Interactuar con la ventana para probar formulario, previsualización y diálogo modal.



🌳 Árbol de contenedores

JFrame (BorderLayout)

  NORTH: headerPanel (FlowLayout)
  
    JLabel "Gestor de usuarios" + icono
    
  WEST: navPanel (GridLayout 5x1)
  
    JButton "Dashboard"
    JButton "Usuarios"
    JButton "Informes"
    JButton "Ajustes"
    JButton "Ayuda"
    
  CENTER: formPanel (GridBagLayout)
  
    JLabel "Nombre" + JTextField
    JLabel "Email" + JTextField
    JLabel "Rol" + JComboBox
    JLabel "Activo" + JCheckBox
    JLabel "Notas" + JTextArea dentro de JScrollPane
    
  EAST: previewPanel (BorderLayout)
  
    JTabbedPane
      Tab "Resumen" → JTextArea (readOnly)
      Tab "Logs" → JTextArea
      
  SOUTH: buttonBar (FlowLayout RIGHT)
  
    JButton "Cancelar"
    JButton "Limpiar"
    JButton "Guardar"



📊 Tabla de propiedades clave
| Panel / Componente | Layout / Tipo       | Insets  | Anchor | Fill             | WeightX       | WeightY |
|-------------------|-------------------|--------|--------|----------------|---------------|---------|
| headerPanel       | FlowLayout         | -      | -      | -               | -             | -       |
| navPanel          | GridLayout (5x1)   | vgap=5 | -      | -               | -             | -       |
| formPanel         | GridBagLayout      | 5,5,5,5| WEST   | HORIZONTAL/BOTH | 1 en campos   | 1 en Notas |
| previewPanel      | BorderLayout       | -      | -      | -               | -             | -       |
| buttonBar         | FlowLayout RIGHT   | 5      | -      | -               | -             | -       |

📄 Documentación

Planificación, wireframe, árbol de contenedores y tabla de propiedades en PDF:

📂 Abrir PDF -> https://github.com/JesusMacias29/Paneles-y-Layouts-como-profesionales/blob/main/Tarea%20M%C3%B3dulo%202%20%E2%80%9CPaneles%20y%20Layouts%20como%20profesionales%E2%80%9D%20JES%C3%9AS%20MAC%C3%8DAS.pdf

📝 Conclusión

Con esta actividad aprendí a organizar una ventana en Java Swing usando diferentes layouts, al principio me costó entender GridBagLayout 
pero al practicarlo me di cuenta de lo útil que es para que los formularios se adapten al tamaño de la ventana, planificar primero el wireframe 
y el árbol de contenedores hizo que después fuera mucho más fácil colocar los paneles y los componentes en el código, también me gustó probar 
el diálogo modal porque hace que la interfaz se vea más completa y profesional, en general esta práctica me ayudó a perderle el miedo a los layouts
y a entender cómo hacer que una interfaz sea flexible y ordenada.
