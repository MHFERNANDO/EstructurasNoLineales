import Materia.controllers.ArbolBinario;

public class App {
    public static void main(String[] args) throws Exception {
        ArbolBinario ab = new ArbolBinario();
        ab.insert(50);
        ab.insert(17);
        ab.insert(76);
        ab.insert(9);
        ab.insert(23);
        ab.insert(54);
        ab.insert(14);
        ab.insert(19);
        System.out.println("Nombre: Fernando Martinez");
        System.out.println("El peso es : " + ab.calcularPeso());
        System.out.println("La altura del arbol es: " + ab.getHeight());
        System.out.println("Arbol InOrder: ");
        ab.imprimirArbol();
        
        System.out.println("Arbol InOrder con alturas: ");
        ab.imprimirInOrderConAlturas();
        System.out.println("Arbol InOrder con factor de equilibrio: ");
        ab.imprimirInOrderConFactorEquilibrio();
        System.out.println("");
        System.out.println("El arbol esta equilibrado: " + ab.estaEquilibrado()); 
        ab.insert(15);
        System.out.println("Agregamos valor = 15");
        System.out.print("Arbol InOrder con factor de equilibrio: ");
        ab.imprimirInOrderConFactorEquilibrio();
        ab.mostrarNodosDesequilibrados();


        ab.buscarArbol( 19);
        
        

    }
}
