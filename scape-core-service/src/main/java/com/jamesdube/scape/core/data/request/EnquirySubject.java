package com.jamesdube.scape.core.data.request;

import com.jamesdube.scape.utils.enums.SubjectGrade;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class EnquirySubject {

    private String subjectCode;

    private SubjectGrade grade;

}
