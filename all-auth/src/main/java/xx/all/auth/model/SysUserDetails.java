package xx.all.auth.model;

import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import java.util.Collection;
import java.util.HashSet;
import java.util.Set;

/**
 * @author Dragon Li
 * @ClassName: SysUserDetails
 * @Description: 用户详细信息
 * @date 2018年5月25日 上午9:15:41
 */
public class SysUserDetails implements UserDetails {
    private static final long serialVersionUID = 1301823233827855757L;
    private final String id;
    private final String username;
    private final String password;
    private final int status;
    private final Set<SysRole> roleSet;
    private final Set<GrantedAuthority> authorities = new HashSet<>();

    public SysUserDetails(SysUser sysUser) {
        this.id = sysUser.getId();
        this.username = sysUser.getUsername();
        this.password = sysUser.getPassword();
        this.status = sysUser.getStatus();
        this.roleSet = sysUser.getRoleSet();
        if (null != roleSet) {
            for (SysRole role : roleSet) {
                authorities.add(new SimpleGrantedAuthority(role.getId()));
            }
        }
    }

    @Override
    public Collection<? extends GrantedAuthority> getAuthorities() {
        return authorities;
    }

    @Override
    public String getPassword() {
        return password;
    }

    @Override
    public String getUsername() {
        return username;
    }

    @Override
    public boolean isAccountNonExpired() {
        return true;
    }

    @Override
    public boolean isAccountNonLocked() {
        return true;
    }

    @Override
    public boolean isCredentialsNonExpired() {
        return true;
    }

    @Override
    public boolean isEnabled() {
        return true;
    }

    public String getId() {
        return id;
    }

    public int getStatus() {
        return status;
    }


    @Override
    public String toString() {
        return "SysUserDetails [username=" + username + ", password=" + password + ", status=" + status + "]";
    }

}
