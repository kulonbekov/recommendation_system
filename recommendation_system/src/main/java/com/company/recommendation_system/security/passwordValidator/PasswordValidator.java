package com.company.recommendation_system.security.passwordValidator;

import org.springframework.stereotype.Service;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

@Service
public class PasswordValidator {
    private final Pattern pattern;

    // пароль длиной от 4 до 32 символов, требующий как минимум 3 из 4 (верхний регистр
    // и строчные буквы, цифры и специальные символы) и не более
    // 2 одинаковых последовательных символа.
    private static final String COMPLEX_PASSWORD_REGEX =
            "^(?:(?=.*\\d)(?=.*[A-Z])(?=.*[a-z])|" +
                    "(?=.*\\d)(?=.*[^A-Za-z0-9])(?=.*[a-z])|" +
                    "(?=.*[^A-Za-z0-9])(?=.*[A-Z])(?=.*[a-z])|" +
                    "(?=.*\\d)(?=.*[A-Z])(?=.*[^A-Za-z0-9]))(?!.*(.)\\1{2,})" +
                    "[A-Za-z0-9!~<>,;:_=?*+#.\"&§%°()\\|\\[\\]\\-\\$\\^\\@\\/]" +
                    "{8,32}$";

    public PasswordValidator(){
        pattern = Pattern.compile(COMPLEX_PASSWORD_REGEX);
    }
    public boolean validate(final String hex){
        Matcher matcher = pattern.matcher(hex);


        return matcher.matches();
    }
}
