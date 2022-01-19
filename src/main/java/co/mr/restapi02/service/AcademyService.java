package co.mr.restapi02.service;

import co.mr.restapi02.mapper.AcademyMapper;
import co.mr.restapi02.mapper.StudentMapper;
import co.mr.restapi02.model.Academy;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class AcademyService {

    @Autowired
    private AcademyMapper academyMapper;
    @Autowired
    private StudentMapper studentMapper;

    public List<Academy> getAcademies(){
        List<Academy> academyList = academyMapper.getAcademies();

        if (academyList != null && academyList.size() > 0) {
            for(Academy academy : academyList){
                academy.setStudentList(studentMapper.getByAcademyId(academy.getId()));
            }
        }

        return  academyList;
    }
}
