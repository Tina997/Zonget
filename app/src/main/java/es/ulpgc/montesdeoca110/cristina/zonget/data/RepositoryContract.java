package es.ulpgc.montesdeoca110.cristina.zonget.data;

import java.util.List;

import es.ulpgc.montesdeoca110.cristina.zonget.app.AccountItem;
import es.ulpgc.montesdeoca110.cristina.zonget.app.AdministratorButtonMenuItem;
import es.ulpgc.montesdeoca110.cristina.zonget.app.ChangeThemeItem;
import es.ulpgc.montesdeoca110.cristina.zonget.app.LostPetItem;
import es.ulpgc.montesdeoca110.cristina.zonget.app.PetForAdoptionItem;
import es.ulpgc.montesdeoca110.cristina.zonget.app.Query;
import es.ulpgc.montesdeoca110.cristina.zonget.app.UserButtonMenuItem;
import es.ulpgc.montesdeoca110.cristina.zonget.app.UserPetItem;

public interface RepositoryContract {

    interface Settings{

        interface FecthZongetDataCallback {
            /** Este método realizará las operaciones especificadas una vez cargada la información
             *  de la aplicación.
             *
             * @param error Especifica si la carga de datos se ha realizado correctamente o no.
             */
            void onZongetDataFetched(boolean error);
        }

        /** Este método se encarga de cargar los datos referentes a los ajustes de la aplicación.
         *
         * @param callback Que realizará las operaciones oportunas tras cargar los datos de la
         *                 aplicación.
         */
        void loadZonget(RepositoryContract.Settings.FecthZongetDataCallback callback);

        interface GetChangeThemeListCallback {
            /** Este método se encarga de actualizar la lista de temas del viewmodel con la lista
             * pasada por parámetro.
             *
             * @param themeList Listas de los temas de aplicación disponibles.
             */
            void setChangeThemeList(List<ChangeThemeItem> themeList);
        }

        /** Este método obtiene la lista de temas disponibles para la aplicación.
         *
         * @param callback Que posteriormente actualiza la lista de los temas en la activity.
         */
        void getChangeThemeList(RepositoryContract.Settings.GetChangeThemeListCallback callback);

        // ------------------------------- Administrator ------------------------------------------

        interface GetAdministratorMenuButtonsListCallback {
            /** Este método se encarga de actualizar la lista de botones del viewmodel con la lista
             *  pasada por parámetro.
             *
             * @param administratorButtons Lista de los botones del administrador de la aplicación.
             */
            void setAdministratorMenuButtonsList(List<AdministratorButtonMenuItem> administratorButtons);
        }

        /** Este método obtiene la lista de botones para el menú del administrador.
         *
         * @param callback Que posteriormente actualiza la lista de los botones en la activity.
         */
        void getAdministratorMenuButtonsList(RepositoryContract.Settings.GetAdministratorMenuButtonsListCallback callback);

        // ----------------------------------- User -----------------------------------------------

        interface GetUserMenuButtonsListCallback {
            /** Este método se encarga de actualizar la lista de botones del viewmodel con la lista
             * pasada por parámetro.
             *
             * @param userButtons Lista de los botones del usuario de la aplicación.
             */
            void setUserMenuButtonsList(List<UserButtonMenuItem> userButtons);
        }

        /**  Este método obtiene la lista de botones para el menú del usuario.
         *
         * @param callback Que posteriormente actualiza la lista de los botones en la activity.
         */
        void getUserMenuButtonsList(RepositoryContract.Settings.GetUserMenuButtonsListCallback callback);

    }

    //=============================================================================================

    interface Accounts {

        interface FecthZongetDataCallback {
            /** Este método realizará las operaciones especificadas una vez cargada la información
             * de la aplicación.
             *
             * @param error Especifica si la carga de datos se ha realizado correctamente o no.
             */
            void onZongetDataFetched(boolean error);
        }

        /** Este método se encarga de cargar la información referente a usurios y sus animales de
         * la aplicación.
         *
         * @param clearFirst Indica si queremos eliminar todas las tablas de datos asociadas a la
         *                   base de datos de la aplicación.
         * @param callback Que realizará las operaciones oportunas tras cargar los datos de la
         *                 aplicación.
         */
        void loadZonget(boolean clearFirst, RepositoryContract.Accounts.FecthZongetDataCallback callback);

        interface GetCheckAccountExistCallback {
            /** Este método se encarga de actualizar la información con los datos de la cuenta que
             * ha iniciado sesión en la aplicación, si existe.
             *
             * @param exist Nos indica si los datos corresponden a una cuenta existente o no.
             * @param account Cuenta con la que se ha iniciado sesión.
             */
            void setCheckAccountExist(boolean exist, AccountItem account);
        }

        /** Este método chequea si existe la cuenta y busca los datos de la misma a partir de la
         * información introducida.
         *
         * @param accountName Nombre de la cuenta.
         * @param accountPassword Contraseña de la cuenta.
         * @param callback Que posteriormente actualiza la información de la cuenta en la activity.
         */
        void getCheckAccount(String accountName, String accountPassword, RepositoryContract.Accounts.GetCheckAccountExistCallback callback);

        interface CheckNewAccountDataExistCallback {
            /** Este método se encarga de actualizar la información para posteriormente insertar o
             * no una nueva cuenta.
             *
             * @param exist Nos indica si los datos corresponden a una cuenta existente o no.
             * @param lastId Identificador para la nueva cuenta.
             */
            void setNewAccountExistCallBack(boolean exist, int lastId);
        }

        /** Este método chequea si existe alguna cuenta asociada a los datos introducidos o no.
         *
         * @param dni DNI del usuario que utilizará la cuenta.
         * @param email Email del usuario que utilizará la cuenta.
         * @param callback Que posteriormente con la información obtenida se decidirá si se inserta
         *                 o no la nueva cuenta.
         */
        void checkNewAccountDataExist(String dni, String email, RepositoryContract.Accounts.CheckNewAccountDataExistCallback callback);

        interface InsertNewAccountCallback{
            /** Este método informa al usuario que su cuenta a sido creada correctamente.
             *
             */
            void onNewAccountInserted();
        }

        /** Este método iserta en la base de datos la nueva cuenta.
         *
         * @param account Cuenta de usuario que se va a insertar.
         * @param callback Que posteriormente informará al usuario.
         */
        void insertNewAccount(AccountItem account, RepositoryContract.Accounts.InsertNewAccountCallback callback);

        interface GetUserPetsListCallback {
            /** Este método se encarga de actualizar la lista de mascotas del viewmodel con la
             * lista pasada por parámetro.
             *
             * @param userPets Lista de mascotas del usuario.
             */
            void setUserPetsList(List<UserPetItem> userPets);
        }

        /** Este método obtiene la lista de mascotas asociadas a un usuario.
         *
         * @param userId Identificador del usuario.
         * @param callback Que posteriormete actualizará la información en la activity.
         */
        void getUserPetsList(int userId, RepositoryContract.Accounts.GetUserPetsListCallback callback);

        interface UpdateUserPetCallback {
            /**
             * Metodo que cambia la vista tras haber editado la mascota
             */
            void onUserPetUpdate();
        }

        /** Este método actualiza la información existente de una mascota de un usuario.
         *
         * @param userPetItem Mascota que de desea actualizar.
         * @param callback
         */
        void updatePet(UserPetItem userPetItem, RepositoryContract.Accounts.UpdateUserPetCallback callback);

        interface DeleteUserPetCallback{
            /**
             * Metodo que cambia la vista tras haber borrado la mascota
             */
            void onUserPetDelete();
        }

        /** Este método elimina la mascota de un usuario.
         *
         * @param pet Mascota que se quiere eliminar.
         * @param deleteUserPetCallback
         */
        void deleteUserPet(UserPetItem pet, RepositoryContract.Accounts.DeleteUserPetCallback deleteUserPetCallback);

        interface InsertNewUserPetCallback{
            /**
             * Metodo que cambia de vista tras añadir una nueva mascota en la lista
             */
            void onUserPetInsert();
        }

        /** Este método inserta una nueva máscota a un usuario.
         *
         * @param userID Identificador del usuario.
         * @param name Nombre de la mascota.
         * @param species Especie de la mascota.
         * @param breed Raza de la mascota.
         * @param chipNum Número del chip de la mascota.
         * @param birthday Fecha de nacimiento de la mascota.
         * @param callback
         */
        void insertNewPet(int userID, String name, String species, String breed, String chipNum, String birthday, RepositoryContract.Accounts.InsertNewUserPetCallback callback);


        interface GetUserListCallback{
            /** Este método se encarga de actualizar la lista de usuarios del viewmodel con la
             * lista pasada por parámetro.
             *
             * @param users Lista de usuarios que el administrador desea buscar.
             */
            void setUsers(List<AccountItem> users);
        }

        /** Este método obtiene una lista de usuarios con la característica pasada por parámetro.
         *
         * @param nameOrDni Nombre o DNI del usuario que desea buscar.
         * @param callback Que posteriormete actualizará la información en la activity.
         */
        void getUserList(String nameOrDni, RepositoryContract.Accounts.GetUserListCallback callback);

    }

    //=============================================================================================

    interface LostPets{

        interface FetchLostPetsDataCallBack{
            /** Este método realizará las operaciones especificadas una vez cargada la información
             * de la aplicación.
             *
             * @param error Especifica si la carga de datos se ha realizado correctamente o no.
             */
            void onLostPetsDataFetched(boolean error);
        }

        /** Este método se encarga de cargar los datos referentes a los animales perdidos de la
         * aplicación.
         *
         * @param callback Que realizará las operaciones oportunas tras cargar los datos de la
         *                 aplicación.
         */
        void loadLostPets(RepositoryContract.LostPets.FetchLostPetsDataCallBack callback);

        interface GetLostPetsListCallback{
            /** Este método se encarga de actualizar la lista de animales perdidos del viewmodel
             * con la lista pasada por parámetro.
             *
             * @param lostPets Lista de animales perdidos.
             */
            void setLostPetsList(List<LostPetItem> lostPets);
        }

        /** Este método obtiene una lista de animales perdidos.
         *
         * @param callback Que posteriormete actualizará la información en la activity.
         */
        void getLostPetsList(RepositoryContract.LostPets.GetLostPetsListCallback callback);

        interface GetLostPetCallback {
            /** Este método se encarga de actualizar el animal perdido del viewmodel con el pasado
             * por parámetro.
             *
             * @param lostPet Animal perdido.
             */
            void setLostPets(LostPetItem lostPet);
        }

        /** Este método obtiene la información relativa al identificador de animal perdido pasado
         * por parámetro.
         *
         * @param id Identificador del animal perdido.
         * @param callback Que posteriormete actualizará la información en la activity.
         */
        void getLostPet(int id, RepositoryContract.LostPets.GetLostPetCallback callback);

    }

    //=============================================================================================

    interface PetsForAdoption{

        interface FetchPetsForAdoptionDataCallBack{
            /** Este método realizará las operaciones especificadas una vez cargada la información
             * de la aplicación.
             *
             * @param error Especifica si la carga de datos se ha realizado correctamente o no.
             */
            void onPetsForAdoptionDataFetched(boolean error);
        }

        /** Este método se encarga de cargar los datos referentes a los animales para adoptar de la
         * aplicación.
         *
         * @param callback Que realizará las operaciones oportunas tras cargar los datos de la
         *                 aplicación.
         */
        void loadCatalog(RepositoryContract.PetsForAdoption.FetchPetsForAdoptionDataCallBack callback);

        interface GetPetsForAdoptionListCallback{
            /** Este método se encarga de actualizar la lista de animales perdidos del viewmodel
             * con la lista pasada por parámetro.
             *
             * @param items Lista de animales para adoptar.
             */
            void setPetsForAdoptionList(List<PetForAdoptionItem> items);
        }

        /** Este método obtiene una lista de animales para adoptar.
         *
         * @param callback Que posteriormete actualizará la información en la activity.
         */
        void getPetsForAdoptionList(RepositoryContract.PetsForAdoption.GetPetsForAdoptionListCallback callback);

        interface GetPetForAdoptionCallback {
            /** Este método se encarga de actualizar el animal para adoptar del viewmodel con el
             * pasado por parámetro.
             *
             * @param petForAdoption Animal para adoptar
             */
            void setPetsForAdoption(PetForAdoptionItem petForAdoption);
        }

        /** Este método obtiene la información relativa al identificador de animal para adoptar
         * pasado por parámetro.
         *
         * @param id Identificador del animal para adoptar.
         * @param callback Que posteriormete actualizará la información en la activity.
         */
        void getPetForAdoption(int id, RepositoryContract.PetsForAdoption.GetPetForAdoptionCallback callback);

    }

    //=============================================================================================

    interface Queries {

        interface SetNewQueryCallback {
            /** Este método se encarga de informar al usuario de si ha habido algún problema al
             * insertar o no la consulta en la base de datos
             *
             * @param correct Indica si la consulta se insertó en la base de datos correctamente.
             */
            void onNewQuerySet(boolean correct);
        }

        /** Este método insserta una consulta.
         *
         * @param senderUserId Identificador de la cuenta del usuario remitente.
         * @param title Título de la consulta.
         * @param Content Descripción de la consulta.
         * @param callback Que posteriormete actualizará informará al usuario.
         */
        void setNewQuery(int senderUserId, String title, String Content, RepositoryContract.Queries.SetNewQueryCallback callback);

        interface GetQueriesListSizeCallback {
            /** Este método se encarga de actualizar los contadores del viewmodel con el tamaño de
             * las listas.
             *
             * @param pendingQueriesListSize Tamaño de la lista de consultas pendientes.
             * @param finishedQueriesListSize Tamaño de la lista de consultas finalizadas.
             */
            void setQueriesListSize(int pendingQueriesListSize, int finishedQueriesListSize);
        }

        /** Este método obtiene el tamaño de las listas de consultas pendientes y finalizadas de un
         *  usuario.
         *
         * @param userId Identificador de la cuenta del usuario.
         * @param callback Que posteriormete actualizará la información de la activity.
         */
        void getQueriesListSize(int userId, RepositoryContract.Queries.GetQueriesListSizeCallback callback);

        interface GetPendingQueriesListCallback {
            /** Este método se encarga de actualizar la lista de consultas pendientes con la pasada
             * por parámetro.
             *
             * @param pendingQueriesList Lista de consultas pendientes.
             */
            void setQueriesList(List<Query> pendingQueriesList);
        }

        /** Este método obtiene la lista de consultas pendientes de un usuario.
         *
         * @param userId Identificador de la cuenta de usuario.
         * @param callback Que posteriormete actualizará la información en la activity.
         */
        void getPendindQueriesList(int userId,RepositoryContract.Queries.GetPendingQueriesListCallback callback);

        interface GetFinishedQueriesListCallback {
            /** Este método se encarga de actualizar la lista de consultas finalizadas del
             * viewmodel con la pasada por parámetro.
             *
             * @param finishedQueriesList Lista de consultas finalizadas.
             */
            void setQueriesList(List<Query> finishedQueriesList);
        }

        /** Este método obtiene la lista de consultas finalizadas de un usuario.
         *
         * @param userId Identificador de la cuenta de usuario.
         * @param callback Que posteriormete actualizará la información en la activity.
         */
        void getFinishedQueriesList(int userId,RepositoryContract.Queries.GetFinishedQueriesListCallback callback);

    }

}
