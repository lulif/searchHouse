package com.gdxx.entity;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import javax.persistence.*;
import java.util.Collection;
import java.util.Date;
import java.util.List;

@Getter
@Setter
@Entity
@Table(name = "user")
@ToString
public class User implements UserDetails {//UserDetails权限集合，账户信息

	private static final long serialVersionUID = 1L;

	@Id // 主键由数据库自动生成（主要是自动增长型）这里要兼容Hibernate和H2
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;

	private String name;
	private String password;
	private String email;
	@Column(name = "phone_number")
	private String phoneNumber;
	private Integer status;
	@Column(name = "create_time")
	private Date createTime;
	@Column(name = "last_login_time")
	private Date lastLoginTime;
	@Column(name = "last_update_time")
	private Date lastUpdateTime;
	// 头像
	private String avatar;
	@Transient // jpa 不和表验证这个字段
	private List<GrantedAuthority> authorityList;

	@Override
	public Collection<? extends GrantedAuthority> getAuthorities() {
		 return this.authorityList;
	}

	@Override
	public String getUsername() {
		return name;
	}

	@Override
	public boolean isAccountNonExpired() {
		// TODO Auto-generated method stub
		return true;
	}

	@Override
	public boolean isAccountNonLocked() {
		// TODO Auto-generated method stub
		return true;
	}

	@Override
	public boolean isCredentialsNonExpired() {
		// TODO Auto-generated method stub
		return true;
	}

	@Override
	public boolean isEnabled() {
		// TODO Auto-generated method stub
		return true;
	}

}
