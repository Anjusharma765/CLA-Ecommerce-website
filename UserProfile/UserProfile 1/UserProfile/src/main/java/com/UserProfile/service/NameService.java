package com.UserProfile.service;

/*import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.UserProfile.model.changeName;
import com.UserProfile.repository.NameRepository;

@Service
public class NameService {
	
	@Autowired
    private NameRepository nameRepository;

    public changeName changeMyName(Long userId, String newName) {
    	changeName user = nameRepository.findById(userid).orElse(null);
        if (user != null) {
            user.setOldName(user.getUsername()); // Store old name
            user.setUsername(newName); // Update username with new name
            user.setNewName(newName); // Store new name
            return nameRepository.save(user);
        }
        return null;
    }

}*/
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.UserProfile.model.changeName;
import com.UserProfile.repository.NameRepository;

@Service
public class NameService {
    
    @Autowired
    private NameRepository nameRepository;

    public changeName changeMyName(Long id, String oldName, String newName) {
        changeName user = new changeName();
        user.setId(id);
        user.setOldName(oldName);
        user.setNewName(newName);
        return nameRepository.save(user);
    }
}
