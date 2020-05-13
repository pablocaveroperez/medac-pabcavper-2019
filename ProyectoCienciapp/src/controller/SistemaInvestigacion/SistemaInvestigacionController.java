package controller.SistemaInvestigacion;


import model.SistemaInvestigacion.*;

public class SistemaInvestigacionController {
    private UniversityController universityController;
    private FacultyController facultyController;
    private DepartmentController departmentController;
    private SpecializationController specializationController;
    private MemberController memberController;

    public SistemaInvestigacionController() {
        universityController = new UniversityController();
        facultyController = new FacultyController();
        departmentController = new DepartmentController();
        specializationController = new SpecializationController();
        memberController = new MemberController();
    }

    public UniversityController getUniversityController() {
        return universityController;
    }

    public FacultyController getFacultyController() {
        return facultyController;
    }

    public DepartmentController getDepartmentController() {
        return departmentController;
    }

    public SpecializationController getSpecializationController() {
        return specializationController;
    }

    public MemberController getMemberController() {
        return memberController;
    }

    // UNIVERSIDAD
    // #################
    public int addUniversity(University oUniversity) {
        return universityController.add(oUniversity);
    }

    public int removeUniversity(University oUniversity) {
        return universityController.remove(oUniversity);
    }

    public int existeUniversity(University oUniversity) {
        return universityController.existeUniversidad(oUniversity);
    }

    // FACULTAD
    // #################
    public int addFaculty(Faculty oFaculty) {
        return facultyController.add(oFaculty);
    }

    public int removeFaculty(Faculty oFaculty) {
        return facultyController.add(oFaculty);
    }

    public int existeFaculty(Faculty oFaculty) {
        return facultyController.existeFacultad(oFaculty);
    }

    // DEPARTAMENTO
    // #################
    public int addDepartment(Department oDepartment) {
        return departmentController.add(oDepartment);
    }

    public int removeDepartment(Department oDepartment) {
        return departmentController.remove(oDepartment);
    }

    public int existeDepartment(Department oDepartment) {
        return departmentController.existeDepartamento(oDepartment);
    }

    // ESPECIALIZACION
    // #################
    public int addSpecialization(Specialization oSpecialization) {
        return specializationController.add(oSpecialization);
    }

    public int removeSpecialization(Specialization oSpecialization) {
        return specializationController.remove(oSpecialization);
    }

    public int existeSpecialization(Specialization oSpecialization) {
        return specializationController.existeEspecializacion(oSpecialization);
    }

    // MIEMBRO
    // #################
    public int addMember(Member oMember) {
        return memberController.add(oMember);
    }

    public int removeMember(Member oMember) {
        return memberController.remove(oMember);
    }

    public int existeMember(Member oMember) {
        return memberController.existeMember(oMember);
    }
}
