
/**
 *
 * @author LSA
 */
public class L1Q1 {

    public static void main(String[] args) {

        printOrdenado();

    }

    public static int[] insertionSort(int[] A) {

        for (int j = 1; j < A.length; j = j + 1) {
            int key = A[j];

            int i = j - 1;
            while (i >= 0 && A[i] > key) {
                A[i + 1] = A[i];
                i = i - 1;
            }
            A[i + 1] = key;
        }

        return A;
    }

    public static void insertionSortAlterado(int[] A, int negativos[], String[] listas) {

        for (int j = 1; j < A.length; j = j + 1) {
            int pkey = A[j];
            int nkey = negativos[j];
            String sKey = listas[j];

            int i = j - 1;

            while (i >= 0 && A[i] > pkey) {

                if (A[i] == pkey) {

                    if (negativos[i] > nkey) {
                        A[i + 1] = A[j];
                        negativos[i + 1] = negativos[j];
                        listas[i + 1] = listas[j];
                        i = i - 1;
                    } else if (negativos[i] <= nkey) {
                        A[i + 1] = A[i];
                        negativos[i + 1] = negativos[i];
                        listas[i + 1] = listas[i];
                        i = i - 1;
                    }

                } else {

                    A[i + 1] = A[i];
                    negativos[i + 1] = negativos[i];
                    listas[i + 1] = listas[i];
                    i = i - 1;

                }
            }

            A[i + 1] = pkey;
            negativos[i + 1] = nkey;
            listas[i + 1] = sKey;

        }

    }

    public static int[] removerDuplicados(int[] v) {
        int tamanho = v.length;
        int w[] = v;

        for (int i = 0; i < tamanho; i++) {
            int removidos = 0;
            int k = i + 1;
            for (int j = i + 1; j < tamanho; j++) {
                if (w[j] == w[i]) {
                    removidos++;
                } else {
                    w[k++] = w[j];
                }
            }
            tamanho = tamanho - removidos;

        }
        int z[] = new int[tamanho];
        System.arraycopy(w, 0, z, 0, tamanho);
        return z;
    }

    public static int somarElementos(int[] lista, boolean positivo) {
        int soma = 0;

        for (int i = 0; i < lista.length; i++) {
            if (positivo) {
                if (lista[i] > 0) {
                    soma = soma + lista[i];
                }
            } else {
                if (lista[i] < 0) {
                    soma = soma + lista[i];
                }
            }

        }

        return soma;
    }

    public static void printOrdenado() {

        Arquivo ar = new Arquivo("src/L1Q1.in", "src/L1Q1.out");

        while (!ar.isEndOfFile()) {
            String linha = ar.readLine();
            String[] valores = linha.split(" ");

            String[] listas = new String[valores.length];

            int[] somaPositivos = new int[valores.length];
            int[] somaNegativos = new int[valores.length];

            int c = 0;
            int l = 0;
            int ql = 0;
            int qntListas = 0;
            String elementos = "";
            String listaSaida = "";

            for (int e = 0; e < valores.length; e++) {
                if (valores[e].equals("start")) {
                    qntListas++;
                }

            }

            for (int i = 0; i < valores.length; i = i + 1) {
                if (valores[i].equals("start")) {

                    elementos = "";
                    ql++;
                } else {

                    elementos = elementos + " " + valores[i];
                    l++;

                    if (i == valores.length - 1 || valores[i + 1].equals("start")) {
                        int[] listaFormatada = insertionSort(removerDuplicados(converterInt(elementos, l)));

                        somaPositivos[c] = somarElementos(listaFormatada, true);
                        somaNegativos[c] = somarElementos(listaFormatada, false);
                        listas[c] = converterStr(listaFormatada);
                        c++;
                        l = 0;

                    }
                }

            }
            if (qntListas == ql) {

                String aux[] = new String[qntListas];
                System.arraycopy(listas, 0, aux, 0, qntListas);

                int auxSomaP[] = new int[qntListas];
                System.arraycopy(somaPositivos, 0, auxSomaP, 0, qntListas);

                int auxSomaN[] = new int[qntListas];
                System.arraycopy(somaNegativos, 0, auxSomaN, 0, qntListas);

                insertionSortAlterado(auxSomaP, auxSomaN, aux);
                ordenarPorNegativos(auxSomaN, auxSomaP, aux);

                for (int k = 0; k < aux.length; k++) {

                    listaSaida = listaSaida + aux[k] + " ";
                }

            }
            listaSaida = listaSaida.substring(0, listaSaida.length() - 1);
            if (ar.isEndOfFile()) {
                ar.print(listaSaida);
            } else {
                ar.println(listaSaida);
            }
            System.out.println(listaSaida);

        }

        ar.close();

    }

    public static int[] converterInt(String elementos, int tamanho) {

        int lista[] = new int[tamanho];
        String[] valores = elementos.split(" ");
        int c = 0;

        for (int i = 0; i < valores.length; i++) {

            if (!valores[i].equals("")) {

                lista[c] = Integer.parseInt(valores[i]);
                c++;
            }
        }

        return lista;
    }

    public static String converterStr(int[] lista) {
        String listaS = "start";
        for (int i = 0; i < lista.length; i++) {
            listaS = listaS + " " + Integer.toString(lista[i]);
        }
        return listaS;
    }

    public static int[] ordenarPorNegativos(int negativos[], int positivos[], String[] listas) {

        for (int j = 1; j < negativos.length; j = j + 1) {
            int pkey = positivos[j];
            int nkey = negativos[j];
            String sKey = listas[j];

            int i = j - 1;

            while (i >= 0 && positivos[i] >= pkey) {

                negativos[i + 1] = negativos[i];

                listas[i + 1] = listas[i];
                i = i - 1;

            }

            negativos[i + 1] = nkey;
            listas[i + 1] = sKey;

        }

        return negativos;
    }

}
