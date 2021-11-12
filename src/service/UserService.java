package service;

import java.util.List;
import model.UserLogin;

public interface UserService {
	// �û���¼
	UserLogin login(UserLogin userLogin);
	
	// �޸�����
	int editPassword(UserLogin userLogin);
	
	// �޸��˻���Ϣ
	int editUser(UserLogin userLogin);
	
	// ����û�
	int addUser(UserLogin userLogin);
	
	// �鿴�����û�
	List<UserLogin> findAll();
	
	// �鿴�����û�
	List<UserLogin> findOne(int userId);
}
