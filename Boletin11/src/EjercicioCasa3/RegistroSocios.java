package EjercicioCasa3;

public class RegistroSocios {
        private Socio[] socios;
        private int iContClientes;

        public RegistroSocios(int numClientes) {
            socios = new Socio[numClientes];
            setiContClientes(0);
        }

        // Metodos getters y setters
        public Socio[] getSocios() {
            return socios;
        }

        public void setSocios(Socio[] socios) {
            this.socios = socios;
        }

        public int getiContClientes() {
            return iContClientes;
        }

        public void setiContClientes(int iContClientes) {
            this.iContClientes = iContClientes;
        }

        // #####################
        // # INTERFACE METHODS #
        // #####################

        public int searchPosition(Socio oObjeto) {
            int iPosicion = -1;
            int iContador = 0;
            while (iPosicion == -1 && iContador < socios.length) {
                if (oObjeto.equals(socios[iContador])) {
                    iPosicion = iContador;
                }
                iContador++;
            }
            return iPosicion;
        }

        public Socio searchObject(Socio oObjeto) {
            Socio oDevolver = null;
            int iContador = 0;
            while (oDevolver == null && iContador < socios.length) {
                if (oObjeto.equals(socios[iContador])) {
                    oDevolver = socios[iContador];
                }
                iContador++;
            }
            return oDevolver;
        }

        public boolean add(Socio oObjeto) {
            boolean bExito = false;
            if (iContClientes < socios.length && searchPosition(oObjeto) == -1) {
                socios[iContClientes] = oObjeto;
                setiContClientes(iContClientes + 1);
                bExito = true;
            }
            return bExito;
        }

        public Socio read(Socio oObjeto) {
            return searchObject(oObjeto);
        }

        public boolean update(Socio oObjeto) {
            boolean bExito = false;
            int iPosicion = searchPosition(oObjeto);
            if (iPosicion != -1) {
                socios[iPosicion] = oObjeto;
                bExito = true;
            }
            return bExito;
        }

        public boolean delete(Socio oObjeto) {
            boolean bExito = false;
            int iPosicion = searchPosition(oObjeto);
            if (iPosicion != -1) {
                for (int iCont = iPosicion + 1; iCont < socios.length; iCont++) {
                    socios[iCont - 1] = socios[iCont];
                }
                socios[socios.length - 1] = null;
                setiContClientes(iContClientes - 1);
                bExito = true;
            }
            return bExito;
        }

        public String printAll() {
            String sResultado = "";

            if (iContClientes == 0) {
                sResultado = "No hay socios registrados en la aplicacion.";
            } else {
                for (int iCont = 0; iCont < iContClientes; iCont++) {
                    sResultado += socios[iCont].imprimir() + "\n";
                }
            }
            return sResultado;
        }




}
