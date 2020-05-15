package controller.SistemaInvestigacion;

import model.SistemaInvestigacion.Department;

import java.util.List;

public interface IDepartmentController {
    // #########
    // # CRUDS #
    // #########
    int add(Department oObject);

    int remove(Department oObject);

    // ###########
    // # QUERIES #
    // ###########
    int existeDepartamento(Department oObject);

    List<Department> getTodosDepartamentos();
}
