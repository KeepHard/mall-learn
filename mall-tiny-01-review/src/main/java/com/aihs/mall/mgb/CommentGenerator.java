package com.aihs.mall.mgb;


import org.mybatis.generator.api.IntrospectedColumn;
import org.mybatis.generator.api.IntrospectedTable;
import org.mybatis.generator.api.dom.java.CompilationUnit;
import org.mybatis.generator.api.dom.java.Field;
import org.mybatis.generator.api.dom.java.FullyQualifiedJavaType;
import org.mybatis.generator.internal.DefaultCommentGenerator;
import org.mybatis.generator.internal.util.StringUtility;

import java.util.Properties;

public class CommentGenerator extends DefaultCommentGenerator {
    private Boolean addRemarkComments;

    private static final String EXAMPLE_SUFFIX = "Example";

    private static final String SWAGGER_IMPOR = "io.swagger.annotations.ApiModelProperty";

    @Override
    public void addConfigurationProperties(Properties properties) {
        super.addConfigurationProperties(properties);
        this.addRemarkComments = StringUtility.isTrue(properties.getProperty("addRemarkComments"));
    }

    @Override
    public void addJavaFileComment(CompilationUnit compilationUnit) {
        super.addJavaFileComment(compilationUnit);
        if(!compilationUnit.isJavaInterface()&&!compilationUnit.getType().getFullyQualifiedName().contains(EXAMPLE_SUFFIX)){
            compilationUnit.addImportedType(new FullyQualifiedJavaType(SWAGGER_IMPOR));
        }
    }

    @Override
    public void addFieldComment(Field field, IntrospectedTable introspectedTable, IntrospectedColumn introspectedColumn) {
        String remarks = introspectedColumn.getRemarks();
        if(this.addRemarkComments&&StringUtility.stringHasValue(remarks)){
            this.addFieldDoc(field,remarks);
            field.addJavaDocLine("@ApiModelProperty(value=\""+remarks+"\")");
        }
    }

    private void addFieldDoc(Field field,String remarks){
        field.addJavaDocLine("/**");
        field.addJavaDocLine(remarks);
        field.addJavaDocLine("**/");
    }
}
