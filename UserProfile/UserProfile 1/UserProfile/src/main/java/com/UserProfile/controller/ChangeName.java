/*package com.UserProfile.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.UserProfile.model.changeName;
import com.UserProfile.service.NameService;

@RestController
@RequestMapping("/api/users")
public class ChangeName {
	@Autowired
    private NameService nameService;

    @PutMapping("/{userId}/change-name")
    public changeName changeMyName(@PathVariable Long userId, @RequestBody String newName) {
        return nameService.changeMyName(userId, newName);
    }

}*/
package com.UserProfile.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.UserProfile.model.changeName;
import com.UserProfile.service.NameService;

@RestController
@RequestMapping("/api/users")
@CrossOrigin(origins="http://localhost:3000/")
public class ChangeName {
    @Autowired
    private NameService nameService;

    @PutMapping("/change-name")
    public changeName changeMyName(@RequestBody changeName nameChange) {
        Long id = nameChange.getId();
        String newName = nameChange.getNewName();
        String oldName = nameChange.getOldName();
        return nameService.changeMyName(id, oldName, newName);
    }
}

