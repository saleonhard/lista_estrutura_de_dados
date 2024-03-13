
/**
 *
 * @author LSA
 */
public class L1Q3 {

    public static void main(String[] args) {

         printArq();
       
    }

    
    public static int[] converterInt(String[] lista) {
        int[] listaInt = new int[lista.length];

        for (int i = 0; i < lista.length; i++) {
            listaInt[i] = Integer.parseInt(lista[i]);
        }
        return listaInt;
    }

    public static Double[] converterDouble(String[] lista) {
        Double[] listaDouble = new Double[lista.length];

        for (int i = 0; i < lista.length; i++) {
            listaDouble[i] = Double.parseDouble(lista[i]);
        }
        return listaDouble;
    }

    public static int[] insertionSort(int[] A) {

        for (int j = 1; j < A.length; j = j + 1) {
            int key = A[j];

            int i = j - 1;
            while (i >= 0 && A[i] < key) {
                A[i + 1] = A[i];
                i = i - 1;
            }
            A[i + 1] = key;
        }

        return A;
    }

    public static Double[] insertionSortDouble(Double[] A) {

        for (int j = 1; j < A.length; j = j + 1) {
            Double key = A[j];

            int i = j - 1;
            while (i >= 0 && A[i] < key) {
                A[i + 1] = A[i];
                i = i - 1;
            }
            A[i + 1] = key;
        }

        return A;
    }

    public static void printArray(int[] A) {
        for (int e : A) {
            System.err.print(e + " ");
        }
        System.err.println("");
    }

    public static void printArrayDouble(Double[] A) {
        for (Double e : A) {
            System.err.print(e + " ");
        }
        System.err.println("");
    }

    public static Lista inserirLista(int[] LE, Double[] LI) {
        Lista lista = new Lista();
        int ce = 0;
        for (int i = 0; i < LE.length; i++) {
            int c = 0;
            ce = 0;
            ListaSLC subList = new ListaSLC();
            No no = new No();
            while (c < LI.length) {

                if (LI[c] > LE[i] && LI[c] < (LE[i] + 1)) {
                    ce++;
                    subList.add(new NoSLC(LI[c]));

                }

                c++;
            }

            no.setChave(LE[i]);
            no.setSubList(subList);
            lista.addLista(lista, no);

        }
        return lista;
    }

   public static  String formatarLista(Lista L) {
        No x = L.cabeca;
        NoSLC e = new NoSLC();
        String listaFormatada = "[";
        int c = 0;

        while (x != null) {

            listaFormatada = listaFormatada + (c == 0 ? Integer.toString(x.chave) : "->" + Integer.toString(x.chave));

            e = x.subList.prim;
            Double lista[] = new Double[x.getSubList().cont];

            for (int i = 0; i < x.getSubList().cont; i++) {
                lista[i] = e.chave;
                e = e.prx;
            }

            insertionSortDouble(lista);
            listaFormatada = listaFormatada + "(";
            for (int i = 0; i < lista.length; i++) {

                listaFormatada = listaFormatada + (i == 0 ? Double.toString(lista[i]) : "->" + Double.toString(lista[i]));

            }
            listaFormatada = listaFormatada + ")";

            x = x.prox;
            c++;

        }
        listaFormatada = listaFormatada + "]";
        
        
        return listaFormatada;
    }
   
   public static void printArq(){
     
     Lista lista = new Lista();
     Arquivo arquivo = new Arquivo("src/L1Q3.in", "src/L1Q3.out");
        int cLE = 0, cLI = 0;
        while (!arquivo.isEndOfFile()) {
            String linha = arquivo.readLine();
            String[] valores = linha.split(" ");
            cLE = 0;
            cLI = 0;
            
            int i = 1;
            while (!valores[i].equals("LI")) {

                cLE++;
                i++;
            }
            i++;
            while (i < valores.length) {
                cLI++;
                i++;
            }
            String[] LE = new String[cLE];
            String[] LI = new String[cLI];
             
           cLE = 0;
           cLI = 0;
           int e = 1;
           while (!valores[e].equals("LI")) {

                LE[cLE] = valores[e];
                cLE++;
                e++;
            }
            e++;
            while (e < valores.length) {
                LI[cLI] = valores[e];
                cLI++;
                e++;
            }
        
        lista = inserirLista(insertionSort(converterInt(LE)), insertionSortDouble(converterDouble(LI)));
        if(arquivo.isEndOfFile()) arquivo.print(formatarLista(lista));
            else arquivo.println(formatarLista(lista));
         

        }

        arquivo.close();

       
   
   }
   
   
   

}
