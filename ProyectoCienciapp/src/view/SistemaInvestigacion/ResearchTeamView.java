package view.SistemaInvestigacion;

import controller.GeneralController;
import model.LimitsDB;
import model.SistemaInvestigacion.Department;
import model.SistemaInvestigacion.ResearchTeam;
import validaciones.ValidaLibrary;

public class ResearchTeamView implements LimitsDB {
    public static void menuEquiposInvestigacion(GeneralController controller) {
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
                default:
                    System.out.println("Volviendo...");
            }
        } while (bOpcion != 4);
    }

    private static int alta(GeneralController controller) {
        byte idResearchTeam = 0;
        String sName = null;
        int iBudget = 0;
        byte idDepartment = 0;
        boolean errorControl = true;
        ResearchTeam oResearchTeam = null;

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
                sName = ValidaLibrary.leer("Introduce el nombre del equipo: ");
                if (sName == null || (sName.length() > MINCHAR && sName.length() < MAXCHAR_40))
                    errorControl = false;
            }catch (Exception exception) {
                System.out.println("Error: " + exception.getMessage());
            }
        }

        errorControl = true;
        while (errorControl) {
            try {
                iBudget = (int) ValidaLibrary.valida("Introduce el presupuesto: ", MINCHAR, MAXBUDGET, 1);
                errorControl = false;
            }catch (Exception exception) {
                System.out.println("Error: " + exception.getMessage());
            }
        }

        errorControl = true;
        while (errorControl) {
            try {
                idDepartment = (byte) ValidaLibrary.valida("Introduce el ID del departamento: ", MINCHAR, MAXCHAR_30, 3);
                errorControl = false;
            }catch (Exception exception) {
                System.out.println("Error: " + exception.getMessage());
            }
        }

        if (sName == null)
            oResearchTeam = new ResearchTeam(idResearchTeam, new Department(idDepartment), iBudget);
        else
            oResearchTeam = new ResearchTeam(idResearchTeam, new Department(idDepartment), sName,iBudget);

        return controller.addResearchTeam(oResearchTeam);
    }

    private static int eliminar(GeneralController controller) {
        return 0;
    }

    private static void busqueda(GeneralController controller) {

    }


    private static byte opcionMenu() {
        byte bOpcion = 0;
        boolean errorControl = true;

        System.out.println("\n\nEQUIPOS DE INVESTIGACION: ");
        System.out.println("1. Anadir.");
        System.out.println("2. Eliminar.");
        System.out.println("3. Busqueda.");
        System.out.println("4. Volver.");

        while (errorControl) {
            try {
                bOpcion = (byte) ValidaLibrary.valida("Introduce una opcion: ", 1, 4, 3);
                errorControl = false;
            } catch (Exception exception) {
                System.out.println("Error: " + exception.getMessage());
            }
        }
        return bOpcion;
    }
}
