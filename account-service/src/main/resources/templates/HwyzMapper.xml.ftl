<?xml version="1.0" encoding="UTF-8"?>
<!DOCTYPE mapper PUBLIC "-//mybatis.org//DTD Mapper 3.0//EN" "http://mybatis.org/dtd/mybatis-3-mapper.dtd">
<mapper namespace="${package.Mapper}.${table.mapperName}">

<#if enableCache>
    <!-- 开启二级缓存 -->
    <cache type="${cacheClassName}"/>

</#if>
<#if baseResultMap>
    <!-- 通用查询映射结果 -->
    <resultMap id="baseResultMap" type="${package.Entity}.${entity}">
<#list table.fields as field>
<#if field.keyFlag><#--生成主键排在第一位-->
        <id column="${field.name}" property="${field.propertyName}" />
</#if>
</#list>
<#list table.commonFields as field><#--生成公共字段 -->
        <result column="${field.name}" property="${field.propertyName}" />
</#list>
<#list table.fields as field>
<#if !field.keyFlag><#--生成普通字段 -->
        <result column="${field.name}" property="${field.propertyName}" />
</#if>
</#list>
    </resultMap>

</#if>
<#if baseColumnList>
    <!-- 通用查询结果列 -->
    <sql id="baseColumnList">
        <#list table.fields as field>${field.columnName}, </#list>
        <#list table.commonFields as field>${field.columnName}<#if field_has_next>, </#if></#list>
    </sql>

</#if>
    <!-- 插入 -->
    <insert id="insertPo" useGeneratedKeys="true" keyProperty="id">
        INSERT INTO ${table.name} (
            <#list table.fields as field>${field.columnName}, </#list>
            description, create_time, create_by, modify_time, modify_by, row_version, is_valid
        )
        VALUES (
            <#list table.fields as field><#noparse>#{</#noparse>${field.propertyName}<#noparse>}</#noparse>, </#list>
            <#noparse>#{description}, now(), #{createBy}, now(), #{modifyBy}, 1, 1</#noparse>
        )
    </insert>

    <!-- 批量插入 -->
    <insert id="batchInsertPo" useGeneratedKeys="true" keyProperty="id" parameterType="java.util.List">
        INSERT INTO ${table.name} (
            <#list table.fields as field>${field.columnName}, </#list>
            description, create_time, create_by, modify_time, modify_by, row_version, is_valid
        )
        VALUES
        <foreach collection="list" item="item" index="index" separator=",">
        (
            <#list table.fields as field><#noparse>#{</#noparse>item.${field.propertyName}<#noparse>}</#noparse>, </#list>
            <#noparse>#{item.description}, now(), #{item.createBy}, now(), #{item.modifyBy}, 1, 1</#noparse>
        )
        </foreach>
    </insert>

    <!-- 更新 -->
    <update id="updatePo" parameterType="${package.Entity}.${entity}">
        UPDATE ${table.name} t SET
        <#list table.fields as field>
        <#if field.columnName != 'id'>
        <#if field.propertyType == 'String'>
        <if test="${field.propertyName} != null and ${field.propertyName} != ''">
        <#else>
        <if test="${field.propertyName} != null">
        </#if>
            t.${field.columnName} = <#noparse>#{</#noparse>${field.propertyName}<#noparse>}</#noparse>,
        </if>
        </#if>
        </#list>
        <if test="description != null and description != ''">
            <#noparse>t.description = #{description},</#noparse>
        </if>
        <if test="modifyBy != null">
            <#noparse>t.modify_by = #{modifyBy},</#noparse>
        </if>
        t.row_version = t.row_version + 1,
        t.modify_time = now()
        WHERE id = <#noparse>#{id}</#noparse>
    </update>

    <!-- 逻辑删除 -->
    <update id="logicalDeletePo" parameterType="Long">
        UPDATE ${table.name} t SET
        t.row_version = t.row_version + 1,
        t.modify_time = now(),
        t.is_valid = 0
        WHERE t.id = <#noparse>#{value}</#noparse>
    </update>

    <!-- 物理删除 -->
    <delete id="physicalDeletePo" parameterType="Long">
        DELETE FROM ${table.name} t
        WHERE t.id = <#noparse>#{value}</#noparse>
    </delete>

    <!-- 根据主键获取对应数据 -->
    <select id="selectPoById" parameterType="Long" resultMap="baseResultMap">
        SELECT <include refid="baseColumnList"/>
        FROM ${table.name} t
        WHERE t.id = <#noparse>#{value}</#noparse>
        AND t.is_valid = 1
    </select>

    <!-- 根据数据对象获取对应数据列表 -->
    <select id="selectPoByExample" parameterType="${package.Entity}.${entity}" resultMap="baseResultMap">
        SELECT <include refid="baseColumnList"/>
        FROM ${table.name} t
        WHERE t.is_valid = 1
        <#list table.fields as field>
        <#if field.propertyType == 'String'>
        <if test="${field.propertyName} != null and ${field.propertyName} != ''">
        <#else>
        <if test="${field.propertyName} != null">
        </#if>
            AND t.${field.columnName} = <#noparse>#{</#noparse>${field.propertyName}<#noparse>}</#noparse>
        </if>
        </#list>
        <#list table.commonFields as field>
        <#if field.columnName != 'is_valid'>
        <#if field.propertyType == 'String'>
        <if test="${field.propertyName} != null and ${field.propertyName} != ''">
        <#else>
        <if test="${field.propertyName} != null">
        </#if>
            AND t.${field.columnName} = <#noparse>#{</#noparse>${field.propertyName}<#noparse>}</#noparse>
        </if>
        </#if>
        </#list>
        ORDER BY t.id DESC
    </select>

    <!-- 根据Map对象获取对应数据列表 -->
    <select id="selectPoByMap" parameterType="java.util.Map" resultMap="baseResultMap">
        SELECT <include refid="baseColumnList"/>
        FROM ${table.name} t
        WHERE t.is_valid = 1
        <!-- 添加自定义条件 -->
        ORDER BY t.id DESC
    </select>

    <!-- 根据Map对象统计记录数 -->
    <select id="countPoByMap" parameterType="java.util.Map" resultType="int">
        SELECT COUNT(*)
        FROM ${table.name} t
        WHERE t.is_valid = 1
        <!-- 添加自定义条件 -->
    </select>
</mapper>
