package com.aihs.mall.tiny.mgb;

import io.swagger.annotations.ApiModelProperty;
import org.mybatis.generator.api.IntrospectedColumn;
import org.mybatis.generator.api.IntrospectedTable;
import org.mybatis.generator.api.dom.java.Field;
import org.mybatis.generator.api.dom.java.FullyQualifiedJavaType;
import org.mybatis.generator.internal.DefaultCommentGenerator;
import org.mybatis.generator.internal.util.StringUtility;

import java.util.Properties;
import java.util.Set;

public class CommentGenerator extends DefaultCommentGenerator {
    private boolean addRemarkComments = false;

    @Override
    public void addConfigurationProperties(Properties properties){
        super.addConfigurationProperties(properties);
        this.addRemarkComments = StringUtility.isTrue(properties.getProperty("addRemarkComments"));
    }

    @Override
    public void addFieldAnnotation(Field field, IntrospectedTable introspectedTable, Set<FullyQualifiedJavaType> imports) {
        super.addFieldAnnotation(field, introspectedTable, imports);
        String remarks = introspectedTable.getRemarks();
        imports.add(new FullyQualifiedJavaType("io.swagger.annotations.ApiModelProperty"));
        if(addRemarkComments&&StringUtility.stringHasValue(remarks)){

        }
    }

    @Override
    public void addFieldComment(Field field, IntrospectedTable introspectedTable, IntrospectedColumn introspectedColumn) {
        String remarks = introspectedColumn.getRemarks();
        if(addRemarkComments&&StringUtility.stringHasValue(remarks)){
            addFieldJavaDoc(field,remarks);
        }
    }

    private void addFieldJavaDoc(Field field,String remarks){
        field.addJavaDocLine("/**");
        String[] remarkLines = remarks.split(System.getProperty("line.separator"));
        for(String remarkLine : remarkLines){
            field.addJavaDocLine(remarkLine);
        }
        addJavadocTag(field,false);
        field.addJavaDocLine("**/");
    }
}
