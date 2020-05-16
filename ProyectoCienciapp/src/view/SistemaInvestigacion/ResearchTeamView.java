package view.SistemaInvestigacion;

import controller.GeneralController;
import model.LimitsDB;
import model.SistemaInvestigacion.Department;
import model.SistemaInvestigacion.ResearchTeam;
import validaciones.ValidaLibrary;

import java.util.List;

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
                case 4:
                    mostrarTodas(controller);
                    break;
                default:
                    System.out.println("Volviendo...");
            }
        } while (bOpcion != 5);
    }

    private static void mostrarTodas(GeneralController controller) {
        List<ResearchTeam> lEquipo;

        lEquipo = controller.getSistemaInvestigacionController().getResearchTeamController().getTodosEquipos();

        if (lEquipo != null) {
            for (ResearchTeam oEquipo : lEquipo) {
                System.out.println(oEquipo);
            }
        }else
            System.out.println("No hay ningun equipo de investigacion en la base de datos.");
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
                if (sName.equals("") || (sName.length() > MINCHAR && sName.length() < MAXCHAR_40))
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

        if (sName.equals(""))
            oResearchTeam = new ResearchTeam(idResearchTeam, new Department(idDepartment), iBudget);
        else
            oResearchTeam = new ResearchTeam(idResearchTeam, new Department(idDepartment), sName,iBudget);

        return controller.addResearchTeam(oResearchTeam);
    }

    private static int eliminar(GeneralController controller) {
        byte idResearchTeam = 0;
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

        oResearchTeam = new ResearchTeam(idResearchTeam);

        return controller.removeResearchTeam(oResearchTeam);
    }

    private static void busqueda(GeneralController controller) {
        byte idResearchTeam = 0;
        boolean errorControl = true;
        ResearchTeam oResearchTeam = null;
        int iNumEquipos;

        while (errorControl) {
            try {
                idResearchTeam = (byte) ValidaLibrary.valida("Introduce el ID del equipo: ", MINCHAR, MAXCHAR_30,3);
                errorControl = false;
            }catch (Exception exception) {
                System.out.println("Error: " + exception.getMessage());
            }
        }

        oResearchTeam = new ResearchTeam(idResearchTeam);
        iNumEquipos = controller.existeResearchTeam(oResearchTeam);

        if (iNumEquipos > 0)
            System.out.println("Existe " + iNumEquipos + " en la base de datos.");
        else
            System.out.println("No existe ningun equipo de investigacion con ese nombre en la base de datos.");
    }


    private static byte opcionMenu() {
        byte bOpcion = 0;
        boolean errorControl = true;

        System.out.println("\n\nEQUIPOS DE INVESTIGACION: ");
        System.out.println("1. Anadir.");
        System.out.println("2. Eliminar.");
        System.out.println("3. Busqueda.");
        System.out.println("4. Mostrar todos.");
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
