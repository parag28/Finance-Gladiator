package Repository;

import Repository.LoginDetailsRepository;

@Repository
public class LoginDetailRepositoryImplementation implements LoginDetailsRepository {
  @PersistenceContext
  Entitymanager entityManager;
  @Transactional
  public String addLoginDetails(LoginDetails loginDetails){
    entityManager.persist(loginDetails);
    return "success";
  }

  @Transactional
  public LoginDetails getLoginDetails(String userId){
    String queryString = "select l from LoginDetails l where l.userName = "+userId;
    List<LoginDetails> loginDetails = entityManager.createQuery(queryString).getResultList();
    return loginDetails.get(0);
  }
  @Transactional
  public List<LoginDetails> getAllLoginDetails(){
    Query query = entityManager.createQuery("from LoginDetails");
    List<LoginDetails> loginDetailsList;
    loginDetailsList = query.getResultList();
    return loginDetailsList;
  }
  @Transactional
  public String updateLoginDetails(LoginDetails loginDetails){
    entityManager.merge(loginDetails);
    return "success";
  }

}
