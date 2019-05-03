package es.ulpgc.montesdeoca110.cristina.zonget.lostPets;

import android.util.Log;

import es.ulpgc.montesdeoca110.cristina.zonget.data.RepositoryContract;

public class LostPetsListModel implements LostPetsListContract.Model {

    public static String TAG = LostPetsListModel.class.getSimpleName();

    private RepositoryContract.LostPets repository;

    public LostPetsListModel(RepositoryContract.LostPets repository) {
        this.repository = repository;
    }

    @Override
    public void fetchLostPetsListData(final RepositoryContract.LostPets.GetLostPetsListCallback callback) {
        Log.e(TAG, "fetchPetsForAdoptionListData()");
        repository.loadLostPets(true, new RepositoryContract.LostPets.FetchLostPetsDataCallBack() {
            @Override
            public void onLostPetsDataFetched(boolean error) {
                if (!error) {
                    repository.getLostPetsList(callback);
                }
            }
        });
    }
}
