export class SETTINGS {
  public static TOASTER_MESSAGES = {
    success: 'SUCCESS',
    error: 'ERROR',
    warning: 'WARNING',
    info: 'INFO',
    custom: 'CUSTOM'
  };


  public static ENDPOINTS = {
    getAvailableProducts: {
      headerParam: {
        showLoading: true,
        showToast: true,
        // showMessage: (new ShowMessageDto().getDefaultSearch()),
        skipAuth: true
      },
      url: 'shoppingcart/api/product/getAvailableProducts',
      type: 'POST'
    },

    calculateBasket: {
      headerParam: {
        showLoading: true,
        showToast: true,
        // showMessage: (new ShowMessageDto().getDefaultSearch()),
        skipAuth: true
      },
      url: 'shoppingcart/api/basket/calculateBasketValue',
      type: 'POST'
    },
  }
}
