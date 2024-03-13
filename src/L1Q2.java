
/**
 *
 * @author LSA
 */
public class L1Q2 {

    public static void main(String[] args) {

        escreverArq(lerListas("elementos"), lerListas("quebra"));

    }

    public static String[] lerListas(String tipoRetorno) {
        Arquivo arquivo = new Arquivo("src/L1Q2.in", "src/L1Q2.out");
        int e = 0;
        int ql = 0;

        while (!arquivo.isEndOfFile()) {
            String linha = arquivo.readLine();
            String[] valores = linha.split(" ");
            int c = 0;
            while (c < valores.length) {
                e++;
                c++;
            }
            ql++;
        }
        int inicio = 0;
        int inicioQL = 0;
        Arquivo arq = new Arquivo("src/L1Q2.in", "src/L1Q2.out");
        String elementos[] = new String[e];
        String qLinha[] = new String[ql - 1];

        while (!arq.isEndOfFile()) {
            String linha = arq.readLine();
            String[] valores = linha.split(" ");
            String aux[] = new String[valores.length];
            System.arraycopy(valores, 0, aux, 0, valores.length);

            if (inicio != 0 && inicioQL < ql - 1) {
                qLinha[inicioQL] = elementos[inicio - 1];
                inicioQL++;
            }
            int c = 0;
            for (int i = 0; i < aux.length; i++) {

                elementos[inicio] = aux[c];
                inicio++;
                c++;
            }

        }

        arquivo.close();
        arq.close();
        if (tipoRetorno.equals("elementos")) {
            return elementos;
        } else {
            return qLinha;
        }
    }

    public static void escreverArq(String[] lista, String[] qlinha) {
        Pilha aux = new Pilha(lista.length);
        Pilha pilha = new Pilha(lista.length);
        Arquivo arq = new Arquivo("src/L1Q2.in", "src/L1Q2.out");
        int numQL = 0;
        int i = 0;
        String saida = "";
        while (!pilha.pilhaCheia() && i < lista.length) {

            if (pilha.pilhaVazia()) {
                pilha.push(lista[i]);

                saida = saida + "push-" + lista[i] + " ";
            } else {

                int c = 0;

                if (lista[i].compareTo(pilha.top()) < 0) {
                    aux.push(pilha.pop());
                    c++;
                    int cpop = c;
                    while (cpop < i) {

                        if (!pilha.pilhaVazia() && lista[i].compareTo(pilha.top()) < 0) {
                            aux.push(pilha.pop());
                            c++;
                        }
                        cpop++;

                    }

                    saida = saida + "pop-" + c + "x" + " ";
                    pilha.push(lista[i]);

                    saida = saida + "push-" + lista[i] + " ";

                    for (int e = 0; e < c; e++) {
                        String pop = aux.pop();
                        pilha.push(pop);

                        saida = saida + "push-" + pop + " ";

                    }

                } else {

                    pilha.push(lista[i]);

                    saida = saida + "push-" + lista[i] + " ";
                }

            }

            i++;

            if (numQL < qlinha.length && lista[i - 1].equals(qlinha[numQL])) {
                saida = saida.substring(0, saida.length() - 1);
                arq.println(saida);
                numQL++;
                pilha.setTopo(-1);
                saida = "";
            } 

        }
        saida = saida.substring(0, saida.length() - 1);
        arq.print(saida);
        arq.close();

    }
}
