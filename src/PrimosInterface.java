public interface PrimosInterface {
    static void extracted(int dim, boolean[] esPrimo) {
        int i;
        for (i = 1; i < dim; i++)
            esPrimo[i] = true;

    }
}
