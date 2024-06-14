public class DiasLluviosos {
    public static final int DIAS_ANIO = 365;
    private boolean[] dias= new boolean[DIAS_ANIO];;
    public DiasLluviosos() {
        for (int i = 0 ; i < dias.length ; i++) {
            dias[i] = false;
        }
    }

    public void registrarQueLlovioElDia(int diaDeAno, boolean llovio) {
        validarDia(diaDeAno);
        dias[diaDeAno] = llovio;
    }

    public boolean consultarSiLlovioElDia(int diaDeAno) {
        validarDia(diaDeAno);
        return dias[diaDeAno];
    }

    public int contarDiasLluviosos() {
        int diasLluviosos = 0;
        for(int i = 0; i < dias.length ; i++) {
            if(dias[i] == true) {
                diasLluviosos++;
            }
        }
        return diasLluviosos;
    }

    public int consultarCuatrimestreMasLluvioso() {
        int cuatrimestreMasLluvioso = 0;
        int cuatrimestres[];
        cuatrimestres = new int[3];
        cuatrimestres[0] = diasLlovidosEnRango(1 , 121);
        cuatrimestres[1] = diasLlovidosEnRango(121 , 243);
        cuatrimestres[2] = diasLlovidosEnRango(244 , 365);
        if ((cuatrimestres[0] >= cuatrimestres[1]) && (cuatrimestres [0] >= cuatrimestres[2]))
            return 1;
        if ((cuatrimestres[1] >= cuatrimestres[0]) && (cuatrimestres [1] >= cuatrimestres[2]))
            return 2;
        if ((cuatrimestres[2] >= cuatrimestres[0]) && (cuatrimestres [2] >= cuatrimestres[1]))
            return 3;
        return -1;
    }

    public int consultarPrimerDiaConLluvia() {
        int i=0;
        for (boolean llovio:dias) {
            if (llovio)
                return i;
            else i++;
        }
        return -1;
    }

    private int validarDia (int diaDeAno) {
        if(diaDeAno<= 0 || diaDeAno> DIAS_ANIO) {
            throw new Error(String.format("D�a(%d) fuera del rango [1-365]",diaDeAno));
        }
        return diaDeAno;
    }

    private int diasLlovidosEnRango( int inicio, int fin ){
        int total = 0;
        for( int i = inicio-1; i <= fin-1; i++ ) {
            if ( dias[i] ) {
                total++;
            }
        }
        return total;
    }

}
