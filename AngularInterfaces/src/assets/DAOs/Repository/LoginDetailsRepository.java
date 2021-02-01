package Repository;

public interface LoginDetailsRepository {
  String addLoginDetails(LoginDetails loginDetails);
  String updateLoginDetails(LoginDetails loginDetails);
  List<LoginDetails> getAllLoginDetails();
  LoginDetails getLoginDetails(String userName);
}
