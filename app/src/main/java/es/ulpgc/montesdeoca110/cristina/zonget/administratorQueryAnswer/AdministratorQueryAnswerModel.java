package es.ulpgc.montesdeoca110.cristina.zonget.administratorQueryAnswer;

import es.ulpgc.montesdeoca110.cristina.zonget.app.Query;
import es.ulpgc.montesdeoca110.cristina.zonget.data.RepositoryContract;

public class AdministratorQueryAnswerModel implements AdministratorQueryAnswerContract.Model {

  public static String TAG = AdministratorQueryAnswerModel.class.getSimpleName();

  private RepositoryContract.Queries queriesRepository;

  public AdministratorQueryAnswerModel(RepositoryContract.Queries queriesRepository) {
    this.queriesRepository = queriesRepository;

  }


}
