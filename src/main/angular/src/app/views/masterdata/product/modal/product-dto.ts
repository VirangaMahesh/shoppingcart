export class ProductDto {

  productID;
  productCode;
  productName;
  cartonSize;
  cartonPrice;
  cartonDiscount;
  perUnitMargin;

  constructor(productDTO?){
    productDTO = productDTO || {};

    this.productID = productDTO.productID || null;
    this.productCode = productDTO.productCode || "";
    this.productName = productDTO.productName || "";
    this.cartonSize = productDTO.cartonSize || 0;
    this.cartonPrice = productDTO.cartonPrice || 0;
    this.cartonDiscount = productDTO.cartonDiscount || 0;
    this.perUnitMargin = productDTO.perUnitMargin || 0;
  }
}
