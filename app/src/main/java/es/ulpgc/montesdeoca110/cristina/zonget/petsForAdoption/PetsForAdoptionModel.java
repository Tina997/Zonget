package es.ulpgc.montesdeoca110.cristina.zonget.petsForAdoption;

import es.ulpgc.montesdeoca110.cristina.zonget.data.RepositoryContract;

public class PetsForAdoptionModel implements PetsForAdoptionContract.Model {

  public static String TAG = PetsForAdoptionModel.class.getSimpleName();

  private RepositoryContract.PetsForAdoption repository;

  public PetsForAdoptionModel(RepositoryContract.PetsForAdoption repository) {
    this.repository = repository;
  }

  @Override
  public void fetchPetsForAdoptionListData(final RepositoryContract.PetsForAdoption
          .GetPetsForAdoptionListCallback callback) {
    repository.loadCatalog(new RepositoryContract.PetsForAdoption
            .FetchPetsForAdoptionDataCallBack() {
      @Override
      public void onPetsForAdoptionDataFetched(boolean error) {
        if (!error) {
          repository.getPetsForAdoptionList(callback);
        }
      }
    });
  }
}
