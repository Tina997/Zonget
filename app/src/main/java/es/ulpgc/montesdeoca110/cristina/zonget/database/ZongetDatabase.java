package es.ulpgc.montesdeoca110.cristina.zonget.database;

import android.arch.persistence.room.Database;
import android.arch.persistence.room.RoomDatabase;

import es.ulpgc.montesdeoca110.cristina.zonget.app.AccountBDItem;
import es.ulpgc.montesdeoca110.cristina.zonget.app.LostPetItem;
import es.ulpgc.montesdeoca110.cristina.zonget.app.PetForAdoptionItem;
import es.ulpgc.montesdeoca110.cristina.zonget.app.PetsItem;
import es.ulpgc.montesdeoca110.cristina.zonget.app.QueryAnswerItem;
import es.ulpgc.montesdeoca110.cristina.zonget.app.QueryItem;
import es.ulpgc.montesdeoca110.cristina.zonget.app.QueryStatusItem;
import es.ulpgc.montesdeoca110.cristina.zonget.app.UserItem;
import es.ulpgc.montesdeoca110.cristina.zonget.app.UserPetBDItem;

@Database(
        entities = {AccountBDItem.class, UserItem.class, PetsItem.class, UserPetBDItem.class, LostPetItem.class, PetForAdoptionItem.class,
                QueryItem.class, QueryAnswerItem.class, QueryStatusItem.class},
        version = 1
)

public abstract class ZongetDatabase extends RoomDatabase {

  public abstract AccountDao accountDao();

  public abstract UserDao userDao();

  public abstract PetsDao petsDao();

  public abstract UsersPetDao usersPetDao();

  public abstract LostPetsDao lostPetsDao();

  public abstract PetsForAdoptionDao petsForAdoptionDao();

  public abstract QueriesDao queriesDao();

  public abstract QueryAnswersDao queryAnswersDao();

  public abstract QueryStatusDao queryStatusDao();


}
