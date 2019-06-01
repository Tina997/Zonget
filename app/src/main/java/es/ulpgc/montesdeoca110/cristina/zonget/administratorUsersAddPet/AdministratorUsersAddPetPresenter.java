package es.ulpgc.montesdeoca110.cristina.zonget.administratorUsersAddPet;

import android.text.Editable;
import android.util.Log;

import java.lang.ref.WeakReference;
import java.util.List;

import es.ulpgc.montesdeoca110.cristina.zonget.app.UserPetItem;
import es.ulpgc.montesdeoca110.cristina.zonget.data.RepositoryContract;

public class AdministratorUsersAddPetPresenter
        implements AdministratorUsersAddPetContract.Presenter {

  public static String TAG = AdministratorUsersAddPetPresenter.class.getSimpleName();

  private WeakReference<AdministratorUsersAddPetContract.View> view;
  private AdministratorUsersAddPetViewModel viewModel;
  private AdministratorUsersAddPetContract.Model model;
  private AdministratorUsersAddPetContract.Router router;

  public AdministratorUsersAddPetPresenter(AdministratorUsersAddPetState state) {
    viewModel = state;
  }

  @Override
  public void injectView(WeakReference<AdministratorUsersAddPetContract.View> view) {
    this.view = view;
  }

  @Override
  public void injectModel(AdministratorUsersAddPetContract.Model model) {
    this.model = model;
  }

  @Override
  public void injectRouter(AdministratorUsersAddPetContract.Router router) {
    this.router = router;
  }


  @Override
  public void insertNewPet(String name, String species, String breed, String chipNum, String birthday) {
    int userID = router.getDataFromPreviousScreen().user.getId();
    model.insertNewPet(userID, name, species, breed, chipNum, birthday, new RepositoryContract.Accounts.InsertNewUserPetCallback() {
            }
    );
    router.navigateToNextScreen();
  }

  @Override
  public String getActualThemeName() {
    return router.getActualThemeName();
  }

  @Override
  public void onBackButtonPressed() {
    router.onBackButtonPressed();
  }

  @Override
  public boolean checkAllDataIntroduced(Editable name, Editable species, Editable breed, Editable chip, Editable birthday) {
    if(name.length()==0||species.length()==0||breed.length()==0||chip.length()==0||birthday.length()==0){
      return false;
    }
    return true;
  }


}
