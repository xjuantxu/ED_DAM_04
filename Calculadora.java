import java.awt.BorderLayout;

import org.eclipse.swt.SWT;
import org.eclipse.swt.events.SelectionAdapter;
import org.eclipse.swt.events.SelectionEvent;
import org.eclipse.swt.widgets.Button;
import org.eclipse.swt.widgets.Display;
import org.eclipse.swt.widgets.Shell;
import org.eclipse.swt.widgets.Text;

import javax.swing.JOptionPane;

/**
 * Clase Calculadora que implementa una calculadora básica con interfaz gráfica.
 * <p>
 * La aplicación permite realizar operaciones matemáticas básicas como:
 * suma, resta, multiplicación y división mediante una interfaz gráfica
 * creada con la librería SWT.
 * <p>
 * El programa gestiona la introducción de números, la ejecución de
 * operaciones y la visualización del resultado en pantalla.
 *
 * @author Juan Cruz García
 * @version 0.1
 * @since 2026
 */
public class Calculadora {

    // Constantes
    final int MAX_DIGITS = 5;
    final int MODE_ENTRADA = 0;
    final int MODE_RESULTADO = 1;

    //Variables
    int modo;
    int digito;
    int valor1;
    int valor2;
    String operacion;
    boolean inicializa_resultado;

    private static Text texto_resultado;

    /**
     * Constructor de la clase Calculadora.
     * <p>
     * Inicializa las variables necesarias para el funcionamiento de la calculadora
     * y, si se indica, dibuja la interfaz gráfica.
     *
     * @param gui indica si se debe mostrar la interfaz gráfica de la calculadora
     */
    public Calculadora(boolean gui) {

        //Inicialización de las variables.
        inicializa();

        if (gui == true) dibujaCalculadora();

    }

    /**
     * Crea y muestra la interfaz gráfica de la calculadora utilizando
     * la librería SWT.
     * <p>
     * Este método construye todos los componentes gráficos:
     * botones numéricos, botones de operaciones y el campo de texto
     * donde se muestran los resultados.
     */
    private void dibujaCalculadora() {

        Display display = Display.getDefault();
        Shell shlCalculadora = new Shell();
        shlCalculadora.setSize(259, 250);
        shlCalculadora.setText("Calculadora");

        //------------------------------------------------ -
        //Números
        //------------------------------------------------ -

        //botón con el número 0
        Button button_0 = new Button(shlCalculadora, SWT.NONE);
        button_0.addSelectionListener(new SelectionAdapter() {
            @Override
            public void widgetSelected(SelectionEvent e) {
                anadeNuevoDigito(0);
            }
        });
        button_0.setText("0");
        button_0.setBounds(23, 163, 40, 33);

        //botón con el número 1
        Button button_1 = new Button(shlCalculadora, SWT.NONE);
        button_1.addSelectionListener(new SelectionAdapter() {
            @Override
            public void widgetSelected(SelectionEvent e) {
                anadeNuevoDigito(1);
            }
        });
        button_1.setText("1");
        button_1.setBounds(23, 124, 40, 33);

        //botón con el número 2
        Button button_2 = new Button(shlCalculadora, SWT.NONE);
        button_2.addSelectionListener(new SelectionAdapter() {
            @Override
            public void widgetSelected(SelectionEvent e) {
                anadeNuevoDigito(2);
            }
        });
        button_2.setText("2");
        button_2.setBounds(69, 124, 40, 33);

        //botón con el número 3
        Button button_3 = new Button(shlCalculadora, SWT.NONE);
        button_3.addSelectionListener(new SelectionAdapter() {
            @Override
            public void widgetSelected(SelectionEvent e) {
                anadeNuevoDigito(3);
            }
        });
        button_3.setText("3");
        button_3.setBounds(115, 124, 40, 33);

        //botón con el número 4
        Button button_4 = new Button(shlCalculadora, SWT.NONE);
        button_4.addSelectionListener(new SelectionAdapter() {
            @Override
            public void widgetSelected(SelectionEvent e) {
                anadeNuevoDigito(4);
            }
        });
        button_4.setText("4");
        button_4.setBounds(23, 85, 40, 33);

        //botón con el número 5
        Button button_5 = new Button(shlCalculadora, SWT.NONE);
        button_5.addSelectionListener(new SelectionAdapter() {
            @Override
            public void widgetSelected(SelectionEvent e) {
                anadeNuevoDigito(5);
            }
        });
        button_5.setText("5");
        button_5.setBounds(69, 85, 40, 33);

        //botón con el número 6
        Button button_6 = new Button(shlCalculadora, SWT.NONE);
        button_6.addSelectionListener(new SelectionAdapter() {
            @Override
            public void widgetSelected(SelectionEvent e) {
                anadeNuevoDigito(6);
            }
        });
        button_6.setText("6");
        button_6.setBounds(115, 85, 40, 33);

        //botón con el número 7
        Button button_7 = new Button(shlCalculadora, SWT.NONE);
        button_7.addSelectionListener(new SelectionAdapter() {
            @Override
            public void widgetSelected(SelectionEvent e) {
                anadeNuevoDigito(7);
            }
        });
        button_7.setText("7");
        button_7.setBounds(23, 46, 40, 33);

        //botón con el número 8
        Button button_8 = new Button(shlCalculadora, SWT.NONE);
        button_8.addSelectionListener(new SelectionAdapter() {
            @Override
            public void widgetSelected(SelectionEvent e) {
                anadeNuevoDigito(8);
            }
        });
        button_8.setBounds(69, 46, 40, 33);
        button_8.setText("8");

        //botón con el número 9
        Button button_9 = new Button(shlCalculadora, SWT.NONE);
        button_9.addSelectionListener(new SelectionAdapter() {
            @Override
            public void widgetSelected(SelectionEvent e) {
                anadeNuevoDigito(9);
            }
        });
        button_9.setText("9");
        button_9.setBounds(115, 46, 40, 33);

        //------------------------------------------------ -
        //Operaciones
        //------------------------------------------------ -

        //botón con la operacion de división
        Button button_12 = new Button(shlCalculadora, SWT.NONE);
        button_12.addSelectionListener(new SelectionAdapter() {
            @Override
            public void widgetSelected(SelectionEvent e) {
                ejecutarOperador("/");
            }
        });
        button_12.setText("/");
        button_12.setBounds(178, 46, 40, 33);

        //botón con la operacion de multiplicación
        Button button_13 = new Button(shlCalculadora, SWT.NONE);
        button_13.addSelectionListener(new SelectionAdapter() {
            @Override
            public void widgetSelected(SelectionEvent e) {
                ejecutarOperador("*");
            }
        });
        button_13.setText("*");
        button_13.setBounds(178, 85, 40, 33);

        //botón con la operacion de suma
        Button button_14 = new Button(shlCalculadora, SWT.NONE);
        button_14.addSelectionListener(new SelectionAdapter() {
            @Override
            public void widgetSelected(SelectionEvent e) {
                ejecutarOperador("+");
            }
        });
        button_14.setText("+");
        button_14.setBounds(178, 124, 40, 33);

        //botón con la operacion de resto
        Button button_15 = new Button(shlCalculadora, SWT.NONE);
        button_15.addSelectionListener(new SelectionAdapter() {
            @Override
            public void widgetSelected(SelectionEvent e) {
                ejecutarOperador("-");
            }
        });
        button_15.setText("-");
        button_15.setBounds(178, 163, 40, 33);

        //botón con la operacion de igual
        Button button_11 = new Button(shlCalculadora, SWT.NONE);
        button_11.addSelectionListener(new SelectionAdapter() {
            @Override
            public void widgetSelected(SelectionEvent e) {
                ejecutarIgual();
            }
        });
        button_11.setText("=");
        button_11.setBounds(69, 163, 86, 33);

        //Texto donde se visualiza el resultado
        texto_resultado = new Text(shlCalculadora, SWT.BORDER);
        texto_resultado.setText("0");
        texto_resultado.setBounds(22, 19, 196, 21);

        shlCalculadora.open();
        shlCalculadora.layout();
        while (!shlCalculadora.isDisposed()) {
            if (!display.readAndDispatch()) {
                display.sleep();
            }
        }
    }

    /**
     * Inicializa las variables internas de la calculadora.
     * <p>
     * Reinicia los valores de los operandos y establece el modo
     * inicial de entrada de datos.
     */
    public void inicializa() {
        operacion = "null";
        valor1 = 0;
        valor2 = 0;
        modo = MODE_ENTRADA;
        inicializa_resultado = true;
    }

    /**
     * Obtiene el resultado actual mostrado en la calculadora
     * en formato de texto.
     *
     * @return cadena de texto que representa el resultado actual
     */
    public String getResultadoString() {
        return texto_resultado.getText();
    }

    /**
     * Establece el valor que se mostrará en la pantalla de la calculadora.
     *
     * @param s cadena de texto que se mostrará como resultado
     */
    public void setResultadoString(String s) {
        texto_resultado.setText(s);
    }

    /**
     * Obtiene el resultado actual de la calculadora como número entero.
     *
     * @return valor entero del resultado mostrado en pantalla
     */
    public int getResultadoInt() {
        String resultado = texto_resultado.getText();
        return Integer.parseInt(resultado);
    }

    /**
     * Añade un nuevo dígito al número que se está introduciendo
     * en la calculadora.
     * <p>
     * Controla también que no se supere el número máximo de dígitos
     * permitidos y elimina ceros iniciales innecesarios.
     *
     * @param digito número que se desea añadir al resultado actual
     */
    public void anadeNuevoDigito(int digito) {
        if (inicializa_resultado)
            setResultadoString("");

        String inputString = getResultadoString();

        if (inputString.indexOf("0") == 0) {
            inputString = inputString.substring(1);
        }

        if ((!inputString.equals("0") || digito > 0) && inputString.length() < MAX_DIGITS) {
            setResultadoString(inputString + digito);
        }

        modo = MODE_ENTRADA;
        inicializa_resultado = false;
    }

    /**
     * Ejecuta una operación matemática seleccionada por el usuario.
     * <p>
     * Guarda el primer operando y la operación seleccionada para
     * poder realizar el cálculo cuando se introduzca el segundo operando.
     *
     * @param new_operacion operación matemática a realizar
     */
    public void ejecutarOperador(String new_operacion) {

        int resultado;

        if (operacion.equals("null")) {
            resultado = getResultadoInt();
            valor1 = resultado;
        } else {
            valor2 = getResultadoInt();
            resultado = ejecutarOperacion();
            muestraResultado(resultado);
            valor1 = resultado;
        }

        inicializa_resultado = true;
        operacion = new_operacion;
    }

    /**
     * Ejecuta la operación matemática pendiente utilizando
     * los operandos introducidos por el usuario.
     * <p>
     * El resultado se muestra en la pantalla de la calculadora.
     */
    public void ejecutarIgual() {
        int resultado = 0;

        valor2 = getResultadoInt();
        resultado = ejecutarOperacion();
        muestraResultado(resultado);

        operacion = "null";
    }

    /**
     * Realiza la operación matemática seleccionada entre los operandos
     * almacenados en la calculadora.
     * <p>
     * También controla errores como la división entre cero.
     *
     * @return resultado de la operación realizada
     */
    public int ejecutarOperacion() {
        int resultado = 0;

        if (operacion.equals("/")) {

            if (valor2 == 0) {
                JOptionPane.showMessageDialog(null, "No se puede dividir por cero", "Error", JOptionPane.ERROR_MESSAGE);
                operacion = "null";
                valor1 = 0;
                modo = MODE_ENTRADA;
                inicializa_resultado = true;
            } else
                resultado = valor1 / valor2;
        }

        if (operacion.equals("*"))
            resultado = valor1 * valor2;

        if (operacion.equals("-"))
            resultado = valor1 - valor2;

        if (operacion.equals("+"))
            resultado = valor1 + valor2;

        return resultado;
    }

    /**
     * Muestra el resultado de una operación en la pantalla
     * de la calculadora.
     *
     * @param resultado valor que se mostrará como resultado
     */
    public void muestraResultado(int resultado) {
        setResultadoString(Integer.toString(resultado));
        valor1 = resultado;
        modo = MODE_RESULTADO;
        inicializa_resultado = true;
    }

    /**
     * Método principal de la aplicación.
     * <p>
     * Inicia la calculadora creando una instancia de la clase
     * con la interfaz gráfica activada.
     *
     * @param args argumentos de la línea de comandos
     */
    public static void main(String args[]) {
        Calculadora calculadora = new Calculadora(true);
    }

}
