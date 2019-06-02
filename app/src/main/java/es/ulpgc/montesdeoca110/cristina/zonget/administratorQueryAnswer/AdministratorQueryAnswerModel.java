package es.ulpgc.montesdeoca110.cristina.zonget.administratorQueryAnswer;

import es.ulpgc.montesdeoca110.cristina.zonget.app.QueryItem;
import es.ulpgc.montesdeoca110.cristina.zonget.data.RepositoryContract;

public class AdministratorQueryAnswerModel implements AdministratorQueryAnswerContract.Model {

  public static String TAG = AdministratorQueryAnswerModel.class.getSimpleName();

  private final RepositoryContract.Queries queriesRepository;

  public AdministratorQueryAnswerModel(RepositoryContract.Queries queriesRepository) {
    this.queriesRepository = queriesRepository;

  }

  @Override
  public void updateQueryAnswer(QueryItem item, String answer, RepositoryContract.Queries.SetQueryAnswerCallback callback){
    queriesRepository.setQueryAnswer(item, answer, callback);
  }


}
