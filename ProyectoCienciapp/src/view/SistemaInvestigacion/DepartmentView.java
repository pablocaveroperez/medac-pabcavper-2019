package view.SistemaInvestigacion;

import controller.GeneralController;
import model.LimitsDB;
import model.SistemaInvestigacion.Department;
import model.SistemaInvestigacion.Faculty;
import validaciones.ValidaLibrary;

public class DepartmentView implements LimitsDB {
    public static void menuDepartamentos(GeneralController controller) {
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

    private static void busqueda(GeneralController controller) {
        byte idDepartamento = 0;
        boolean errorControl = true;
        Department oDepartment = null;
        int iNumDepartamentos;

        while (errorControl) {
            try {
                idDepartamento = (byte) ValidaLibrary.valida("Introduce el ID del departamento: ", MINCHAR, MAXCHAR_30, 3);
                errorControl = false;
            }catch (Exception exception) {
                System.out.println("Error: " + exception.getMessage());
            }
        }

        oDepartment = new Department(idDepartamento);
        iNumDepartamentos = controller.existeDepartment(oDepartment);

        if (iNumDepartamentos > 0)
            System.out.println("Existe " + iNumDepartamentos + " en la base de datos.");
        else
            System.out.println("No existe ningun departamento con ese nombre en la base de datos.");
    }

    private static int eliminar(GeneralController controller) {
        byte idDepartamento = 0;
        boolean errorControl = true;
        Department oDepartment = null;

        while (errorControl) {
            try {
                idDepartamento = (byte) ValidaLibrary.valida("Introduce el ID del departamento: ", MINCHAR, MAXCHAR_30, 3);
                errorControl = false;
            }catch (Exception exception) {
                System.out.println("Error: " + exception.getMessage());
            }
        }

        oDepartment = new Department(idDepartamento);

        return controller.removeDepartment(oDepartment);
    }

    private static int alta(GeneralController controller) {
        byte idDepartment = 0;
        String sName = null;
        String sFaculName = null;
        boolean errorControl = true;
        Department oDepartment = null;

        while (errorControl) {
            try {
                idDepartment = (byte) ValidaLibrary.valida("Introduce el ID del departamento: ", MINCHAR, MAXCHAR_30, 3);
                errorControl = false;
            }catch (Exception exception) {
                System.out.println("Error: " + exception.getMessage());
            }
        }

        errorControl = true;
        while (errorControl) {
            try {
                sFaculName = ValidaLibrary.leer("Introduce el nombre de la facultad: ");
                if (sFaculName.length() > MINCHAR && sFaculName.length() <= MAXCHAR_50)
                    errorControl = false;
            }catch (Exception exception) {
                System.out.println("Error: " + exception.getMessage());
            }
        }

        errorControl = true;
        while (errorControl) {
            try {
                sName = ValidaLibrary.leer("Introduce el nombre del departamento: ");
                if (sName == null || (sName.length() > MINCHAR && sName.length() < MAXCHAR_50))
                    errorControl = false;
            }catch (Exception exception) {
                System.out.println("Error: " + exception.getMessage());
            }
        }

        if (sName == null) {
            oDepartment = new Department(idDepartment, new Faculty(sFaculName));
        }else {
            oDepartment = new Department(idDepartment, new Faculty(sFaculName),sName);
        }

        return controller.addDepartment(oDepartment);
    }

    private static byte opcionMenu() {
        byte bOpcion = 0;
        boolean errorControl = true;

        System.out.println("\n\nDEPARTAMENTO: ");
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
