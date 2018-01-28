 public boolean sendEmail(final String email, final String subject, final String text) {

        boolean isSent = false;
        Properties props = System.getProperties();
        props.put("mail.smtp.host", "mail.host");
        props.put("mail.smtp.port", "mail.port");
        props.put("mail.smtps.auth", "true");
        props.put("mail.smtps.starttls.enable", "true");
        Authenticator auth=  new javax.mail.Authenticator() {
            protected PasswordAuthentication getPasswordAuthentication() {
            return new PasswordAuthentication("mail.sender.username", "mail.sender.password");
           }
            };
        Session session = Session.getInstance(props,auth); 
        if (applicationProperties.emailEnabled() && email != null) {
            MimeMessage simpleMessage = new MimeMessage(session);
            try {
                simpleMessage.setRecipients(MimeMessage.RecipientType.TO, email);
                simpleMessage.setContent(text, "text/html; charset=utf-8");
                simpleMessage.setSubject(subject);
            } catch (MessagingException e) {
                e.printStackTrace();
            }
            
            mailSender.send(simpleMessage);
            isSent = true;
        }
        return isSent;
    }

    public boolean sendSMS(final String sms, final String text) {

        boolean isSent = false;
        Properties props = System.getProperties();
        props.put("mail.smtp.host", "mail.host");
        props.put("mail.smtp.port", "mail.port");
        props.put("mail.smtps.auth", "true");
        props.put("mail.smtps.starttls.enable", "true");
        Authenticator auth=  new javax.mail.Authenticator() {
            protected PasswordAuthentication getPasswordAuthentication() {
            return new PasswordAuthentication("mail.sender.username", "mail.sender.password");
           }
            };
        Session session = Session.getInstance(props,auth); 
        if (applicationProperties.smsEnabled()) {
            MimeMessage simpleMessage = new MimeMessage(session);
            try {
                simpleMessage.setRecipients(MimeMessage.RecipientType.TO, sms);
                simpleMessage.setContent(text, "text/html; charset=utf-8");
            } catch (MessagingException e) {
                e.printStackTrace();
            }
            
            mailSender.send(simpleMessage);
            isSent = true;
        }
        return isSent;
    }


