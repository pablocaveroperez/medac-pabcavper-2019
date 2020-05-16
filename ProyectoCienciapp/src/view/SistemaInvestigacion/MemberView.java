package view.SistemaInvestigacion;

import controller.GeneralController;
import model.ArticulosUsuarios.User;
import model.LimitsDB;
import model.SistemaInvestigacion.Member;
import model.SistemaInvestigacion.ResearchTeam;
import model.SistemaInvestigacion.Specialization;
import validaciones.ValidaLibrary;

import java.util.Calendar;
import java.util.GregorianCalendar;
import java.util.List;

public class MemberView implements LimitsDB {
    public static void menuMiembros(GeneralController controller) {
        byte bOpcion = 0;
        do {
            bOpcion = opcionMenu();
            switch (bOpcion) {
                case 1:
                    if (alta(controller) != 0)
                        System.out.println("Ha sido anadida con exito.");
                    else
                        System.out.println("Ya se encuentra en el sistema.");
                    break;
                case 2:
                    if (eliminar(controller) != 0)
                        System.out.println("Ha sido eliminado con existo.");
                    else
                        System.out.println("No existe en el sistema.");
                    break;
                case 3:
                    busqueda(controller);
                    break;
                case 4:
                    mostrarTodas(controller);
                    break;
                default:
                    System.out.println("Volviendo...");
            }
        } while (bOpcion != 5);
    }

    private static void mostrarTodas(GeneralController controller) {
        List<Member> lMiembro;

        lMiembro = controller.getSistemaInvestigacionController().getMemberController().getTodosMiembros();

        if (lMiembro.size() != 0) {
            for (Member oMember : lMiembro) {
                System.out.println(oMember);
            }
        }else
            System.out.println("No hay ningun miembro en la base de datos.");
    }

    private static int alta(GeneralController controller) {
        String sDNI = null;
        GregorianCalendar birthDate = new GregorianCalendar();
        String sName = null;
        String sSurname = null;
        String sSpecialization = null;
        byte idResearchTeam = 0;
        String sUser = null;
        boolean errorControl = true;
        Member oMember = null;

        while (errorControl) {
            try {
                sDNI = ValidaLibrary.leer("Introduce el DNI: ");
                if (sDNI.length() == DNILENGTH)
                    errorControl = false;
            }catch (Exception exception) {
                System.out.println("Error: " + exception.getMessage());
            }
        }

        int shAno = 0, bMes = 0, bDia = 0;

        errorControl = true;
        while (errorControl) {
            try {
                shAno = (int) ValidaLibrary.valida("Introduce el ano(Pon 1901 si no quieres introducir una fecha):",1900,2020,1);
                errorControl = false;
            }catch (Exception exception) {
                System.out.println("Error: " + exception.getMessage());
            }
        }

        if (shAno != 1901) {
            birthDate.set(Calendar.YEAR, shAno);
            System.out.println("Escoge el mes: ");
            System.out.println("1. Enero.");
            System.out.println("2. Febrero.");
            System.out.println("3. Marzo.");
            System.out.println("4. Abril.");
            System.out.println("5. Mayo.");
            System.out.println("6. Junio.");
            System.out.println("7. Julio.");
            System.out.println("8. Agosto.");
            System.out.println("9. Septiembre.");
            System.out.println("10. Octubre.");
            System.out.println("11. Noviembre.");
            System.out.println("12. Diciembre.");
            System.out.println("13. Cancelar.");


            errorControl = true;
            while (errorControl) {
                try {
                    bMes = (int) ValidaLibrary.valida("Introduce el mes(1-13): ", 1,13,1);
                    errorControl = false;
                }catch (Exception exception) {
                    System.out.println("Error: " + exception.getMessage());
                }
            }

            if (bMes != 13){
                birthDate.set(Calendar.MONTH, bMes-1);

                errorControl = true;
                while (errorControl) {
                    try {
                        bDia = (int) ValidaLibrary.valida("Introduce el dia del mes: ", 1, birthDate.getActualMaximum(Calendar.DAY_OF_MONTH), 1);
                        errorControl = false;
                    }catch (Exception exception) {
                        System.out.println("Error: " + exception.getMessage());
                    }
                }
                birthDate.set(Calendar.DATE, bDia);

            }else{
                birthDate = null;
            }
        }else{
            birthDate = null;
        }

        errorControl = true;
        while (errorControl) {
            try {
                sName = ValidaLibrary.leer("Introduce el nombre: ");
                if (sName.length() > MINCHAR && sName.length() < MAXCHAR_50)
                    errorControl = false;
            }catch (Exception exception) {
                System.out.println("Error: " + exception.getMessage());
            }
        }

        errorControl = true;
        while (errorControl) {
            try {
                sSurname = ValidaLibrary.leer("Introduce el apellido: ");
                if (sSurname.length() > MINCHAR && sSurname.length() < MAXCHAR_50)
                    errorControl = false;
            }catch (Exception exception) {
                System.out.println("Error: " + exception.getMessage());
            }
        }

        errorControl = true;
        while (errorControl) {
            try {
                sSpecialization = ValidaLibrary.leer("Introduce la especializacion: ");
                if (sSpecialization.length() > MINCHAR && sSpecialization.length() < MAXCHAR_50)
                    errorControl = false;
            }catch (Exception exception) {
                System.out.println("Error: " + exception.getMessage());
            }
        }

        errorControl = true;
        while (errorControl) {
            try {
                idResearchTeam = (byte) ValidaLibrary.valida("Introduce el ID del equipo: ", MINCHAR, MAXCHAR_30,3);
                errorControl = false;
            }catch (Exception exception) {
                System.out.println("Error: " + exception.getMessage());
            }
        }

        errorControl = true;
        while (errorControl) {
            try {
                sUser = ValidaLibrary.leer("Introduce el nombre de usuario: ");
                if (sUser.length() > MINCHAR && sUser.length() < MAXCHAR_50)
                    errorControl = false;
            }catch (Exception exception) {
                System.out.println("Error: " + exception.getMessage());
            }
        }

        if (birthDate == null) {
            oMember = new Member(sDNI,sName,sSurname,new Specialization(sSpecialization),new ResearchTeam(idResearchTeam),new User(sUser));
        }else
            oMember = new Member(sDNI,birthDate,sName,sSurname,new Specialization(sSpecialization),new ResearchTeam(idResearchTeam),new User(sUser));

        return controller.addMember(oMember);
    }

    private static int eliminar(GeneralController controller) {
        String sDNI = null;
        Member oMember = null;
        boolean errorControl = true;

        while (errorControl) {
            try {
                sDNI = ValidaLibrary.leer("Introduce el DNI: ");
                if (sDNI.length() == DNILENGTH)
                    errorControl = false;
            }catch (Exception exception) {
                System.out.println("Error: " + exception.getMessage());
            }
        }

        oMember = new Member(sDNI);

        return controller.removeMember(oMember);
    }

    private static void busqueda(GeneralController controller) {
        String sDNI = null;
        Member oMember = null;
        int iNumMiembros;
        boolean errorControl = true;

        while (errorControl) {
            try {
                sDNI = ValidaLibrary.leer("Introduce el DNI: ");
                if (sDNI.length() == DNILENGTH)
                    errorControl = false;
            }catch (Exception exception) {
                System.out.println("Error: " + exception.getMessage());
            }
        }

        oMember = new Member(sDNI);
        iNumMiembros = controller.existeMember(oMember);

        if (iNumMiembros > 0)
            System.out.println("Existe " + iNumMiembros + " en la base de datos.");
        else
            System.out.println("No existe ningun miembro con ese dni en la base de datos.");
    }

    private static byte opcionMenu() {
        byte bOpcion = 0;
        boolean errorControl = true;

        System.out.println("\n\nMIEMBRO: ");
        System.out.println("1. Anadir.");
        System.out.println("2. Eliminar.");
        System.out.println("3. Busqueda.");
        System.out.println("4. Mostrar Todos.");
        System.out.println("5. Volver.");

        while (errorControl) {
            try {
                bOpcion = (byte) ValidaLibrary.valida("Introduce una opcion: ", 1, 5, 3);
                errorControl = false;
            } catch (Exception exception) {
                System.out.println("Error: " + exception.getMessage());
            }
        }
        return bOpcion;
    }
}
