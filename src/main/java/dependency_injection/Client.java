package dependency_injection;

public class Client {
	AbstactDAO dao;

	public Client() {
		dao = FactoryDao.getDAO();
	}

	public AbstactDAO getDao() {
		return dao;
	}

	public void setDao(AbstactDAO dao) {
		this.dao = dao;
	}

	public void execute() {
		dao.insert();
		dao.update();
		dao.delete();
	}

}
