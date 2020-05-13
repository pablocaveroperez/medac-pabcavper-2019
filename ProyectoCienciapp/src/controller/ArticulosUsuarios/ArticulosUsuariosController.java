package controller.ArticulosUsuarios;


import model.ArticulosUsuarios.*;

public class ArticulosUsuariosController {
    private UserController userController;
    private CategoryController categoryController;
    private ArticleTypeController articleTypeController;
    private ArticleController articleController;
    private ArticleRatingUserController articleRatingUserController;
    private ArticleXCategoryController articleXCategoryController;

    public ArticulosUsuariosController() {
        userController = new UserController();
        categoryController = new CategoryController();
        articleTypeController = new ArticleTypeController();
        articleController = new ArticleController();
        articleRatingUserController = new ArticleRatingUserController();
        articleXCategoryController = new ArticleXCategoryController();
    }

    public UserController getUserController() {
        return userController;
    }

    public CategoryController getCategoryController() {
        return categoryController;
    }

    public ArticleTypeController getArticleTypeController() {
        return articleTypeController;
    }

    public ArticleController getArticleController() {
        return articleController;
    }

    public ArticleRatingUserController getArticleRatingUserController() {
        return articleRatingUserController;
    }

    public ArticleXCategoryController getArticleXCategoryController() {
        return articleXCategoryController;
    }

    // USUARIO
    public int addUser(User oUser) {
        return userController.add(oUser);
    }

    public int removeUser(User oUser) {
        return userController.remove(oUser);
    }

    public int existeUser(User oUser) {
        return userController.existeUser(oUser);
    }

    // CATEGORIA
    public int addCategory(Category oCategory) {
        return categoryController.add(oCategory);
    }

    public int removeCategory(Category oCategory) {
        return categoryController.remove(oCategory);
    }

    public int existeCategory(Category oCategory) {
        return categoryController.existeCategory(oCategory);
    }

    // TIPO ARTICULO
    public int addArticleType(ArticleType oArticleType) {
        return articleTypeController.add(oArticleType);
    }

    public int removeArticleType(ArticleType oArticleType) {
        return articleTypeController.remove(oArticleType);
    }

    public int existeArticleType(ArticleType oArticleType) {
        return articleTypeController.existeArticleType(oArticleType);
    }

    // ARTICULO
    public int addArticle(Article oArticle) {
        return articleController.add(oArticle);
    }

    public int removeArticle(Article oArticle) {
        return articleController.remove(oArticle);
    }

    public int existeArticle(Article oArticle) {
        return articleController.existeArticle(oArticle);
    }

    // PUNTUACION DEL ARTICULO POR USUARIO
    public int addArticleRatingUser(ArticleRatingUser oArticleRatingUser) {
        return articleRatingUserController.add(oArticleRatingUser);
    }

    public int removeArticleRatingUser(ArticleRatingUser oArticleRatingUser) {
        return articleRatingUserController.remove(oArticleRatingUser);
    }

    public int existeArticleRatingUser(ArticleRatingUser oArticleRatingUser) {
        return articleRatingUserController.existeArticleRatingUser(oArticleRatingUser);
    }

    // CATEGORIA DEL ARTICULO
    public int addArticleXCategory(ArticleXCategory oArticleXCategory) {
        return articleXCategoryController.add(oArticleXCategory);
    }

    public int removeArticleXCategory(ArticleXCategory oArticleXCategory) {
        return articleXCategoryController.remove(oArticleXCategory);
    }

    public int existeArticleXCategory(ArticleXCategory oArticleXCategory) {
        return articleXCategoryController.existeArticleXCategoryController(oArticleXCategory);
    }
}
