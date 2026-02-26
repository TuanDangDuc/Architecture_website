package com.Architecture_Website.Architecture_Website.Service;

import com.Architecture_Website.Architecture_Website.Model.AccountEntity;
import com.Architecture_Website.Architecture_Website.Model.MyUserPrincipal;
import com.Architecture_Website.Architecture_Website.Repository.AccountRepository;
import lombok.Data;
import lombok.RequiredArgsConstructor;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

@Service
@Data
@RequiredArgsConstructor
public class MyUserDetailService implements UserDetailsService {
    private final AccountRepository accountRepository;

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        AccountEntity acc = accountRepository.findAccountEntitiesByUsername(username);

        if (acc == null)
            throw new UsernameNotFoundException(username);


        return new MyUserPrincipal(acc);
    }
}
