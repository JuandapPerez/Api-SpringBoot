package com.cursoSpring.platzi_markket.persistence.mapper;

import com.cursoSpring.platzi_markket.domain.PurchaseItem;
import com.cursoSpring.platzi_markket.persistence.entity.ComprasProducto;
import org.mapstruct.*;

@Mapper(componentModel = "spring", uses = {ProductMapper.class})
public interface PurchaseItemMapper {

    @Mappings({
            @Mapping(source = "id.idProducto", target = "productId"),
            @Mapping(source = "cantidad", target = "quantity"),
            @Mapping(source = "estado", target = "active")
    })
    PurchaseItem toPurchaseItem(ComprasProducto producto);

    @InheritInverseConfiguration
    @Mappings({
            @Mapping(target = "compra", ignore = true),
            @Mapping(target = "producto", ignore = true),
            @Mapping(target = "id.idCompra", ignore = true)
    })
    ComprasProducto toComprasProducto(PurchaseItem item);
}
