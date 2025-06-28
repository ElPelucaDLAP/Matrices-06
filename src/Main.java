public class Main {
    public static void main(String[] args) {
        //Hacer un programa que dada la matriz de secuencias de caracteres definida y precargada,
        // permita encontrar por cada fila la posición de inicio y fin de la anteúltima secuencia
        // (considerar comenzar a buscarla a partir de la última posición de la fila).
        int[][] matriz ={
                {1,0,2,3,4,0,0,2,4,0},
                {0,3,2,4,0,0,0,2,1,0},
                {0,2,3,2,0,2,2,1,0,0},
                {0,3,4,2,0,9,2,1,0,0},
                {0,2,2,2,2,2,2,0,0,0},
        };
        final int MAXF = 5;
        final int MAXC = 10;
        buscarAnteUltimaPosicion(MAXF,MAXC,matriz);
    }
    public static void buscarAnteUltimaPosicion (final int MAXF, final int MAXC, int [][] matriz){
        int numeroSecuencia;
        int inicioSecuencia;
        int finSecuencia;
        int[] inicio = {0,0,0,0,0};
        int[] fin = {0,0,0,0,0};
        for (int i = 0; i<MAXF; i++){
            numeroSecuencia=0;
            finSecuencia = MAXC-1;
            inicioSecuencia = finSecuencia;
            while (numeroSecuencia!=2){
                inicioSecuencia=buscarInicio(finSecuencia-1,matriz[i]);
                if (inicioSecuencia<MAXC){
                    finSecuencia=buscarFin(inicioSecuencia, matriz[i]);
                }
                numeroSecuencia++;
                if (numeroSecuencia==2){
                    inicio[i]=inicioSecuencia;
                    fin[i]=finSecuencia;
                }
            }

        }
      mostrar(inicio,fin);
    }
    public static void mostrar (int[] array1, int[]array2) {
        for (int i = 0; i<array1.length; i++){
            System.out.println(array2[i]+"|"+array1[i]);
        }
    }
    public static int buscarInicio (int fin, int[] array) {
        int inicio = fin;
        while (inicio>-1 && array[inicio]==0){
            inicio--;
        }
        return inicio;
    }
    public static int buscarFin (int inicio, int[] array) {
        while (inicio>-1 && array[inicio]!=0){
            inicio--;
        }
        return inicio+1;
    }
}