package cn.lemon.entity;

import com.baomidou.mybatisplus.annotation.TableName;
import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import java.time.LocalDateTime;
import java.io.Serializable;

import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.experimental.Accessors;

import javax.validation.constraints.NotBlank;

/**
 * <p>
 * 
 * </p>
 *
 * @author lemon:柠檬
 * @since 2021-04-09
 */
@Data
@EqualsAndHashCode(callSuper = false)
@Accessors(chain = true)
@TableName("m_blog")
public class Blog implements Serializable {

    private static final long serialVersionUID = 1L;

    @TableId(value = "id", type = IdType.AUTO)
    private Long id;

    private Long userId;
    @NotBlank(message = "标题不能为空")
    private String title;
    @NotBlank(message = "摘要不能为空")
    private String description;
    @NotBlank(message = "内容不能为空")
    private String content;

    @JsonFormat(pattern = "yyyy-MM-dd")
    private LocalDateTime created;

    private Integer status;


}
